package com.seven.jong.service.security;

import com.seven.jong.VO.security.UserSecurityVO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.userdetails.UserDetailsChecker;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.rememberme.CookieTheftException;
import org.springframework.security.web.authentication.rememberme.InvalidCookieException;
import org.springframework.security.web.authentication.rememberme.RememberMeAuthenticationException;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public abstract class CustomRememberMeServices implements RememberMeServices, InitializingBean, LogoutHandler {
        public static final String SPRING_SECURITY_REMEMBER_ME_COOKIE_KEY = "remember-me";
        public static final String DEFAULT_PARAMETER = "remember-me";
        public static final int TWO_WEEKS_S = 1209600;
        private static final String DELIMITER = ":";
        protected final Log logger = LogFactory.getLog(this.getClass());
        protected final MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();
        private IUserSecurityService userSecurityService;
        private UserDetailsChecker userDetailsChecker = new AccountStatusUserDetailsChecker();
        private AuthenticationDetailsSource<HttpServletRequest, ?> authenticationDetailsSource = new WebAuthenticationDetailsSource();
        private String cookieName = "remember-me";
        private String cookieDomain;
        private String parameter = "remember-me";
        private boolean alwaysRemember;
        private String key;
        private int tokenValiditySeconds = 1209600;
        private Boolean useSecureCookie = null;


        protected CustomRememberMeServices(String key, IUserSecurityService userSecurityService) {
            Assert.hasLength(key, "key cannot be empty or null");
            Assert.notNull(userSecurityService, "UserDetailsService cannot be null");
            this.key = key;
            this.userSecurityService = userSecurityService;
        }

        public void afterPropertiesSet() {
            Assert.hasLength(this.key, "key cannot be empty or null");
            Assert.notNull(this.userSecurityService, "A UserDetailsService is required");
        }

        public final Authentication autoLogin(HttpServletRequest request, HttpServletResponse response) {
            String rememberMeCookie = this.extractRememberMeCookie(request);
            if (rememberMeCookie == null) {
                return null;
            } else {
                this.logger.debug("Remember-me cookie detected");
                if (rememberMeCookie.length() == 0) {
                    this.logger.debug("Cookie was empty");
                    this.cancelCookie(request, response);
                    return null;
                } else {
                    UserSecurityVO user = null;

                    try {
                        String[] cookieTokens = this.decodeCookie(rememberMeCookie);
                        user = this.processAutoLoginCookie(cookieTokens, request, response);
//                        this.userDetailsChecker.check(user);
                        this.logger.debug("Remember-me cookie accepted");
                        System.out.println("Remember-me cookie accepted" + user);
                        return this.createSuccessfulAuthentication(request, user);
                    } catch (CookieTheftException var6) {
                        this.cancelCookie(request, response);
                        throw var6;
                    } catch (UsernameNotFoundException var7) {
                        this.logger.debug("Remember-me login was valid but corresponding user not found.", var7);
                    } catch (InvalidCookieException var8) {
                        this.logger.debug("Invalid remember-me cookie: " + var8.getMessage());
                    } catch (AccountStatusException var9) {
                        this.logger.debug("Invalid UserDetails: " + var9.getMessage());
                    } catch (RememberMeAuthenticationException var10) {
                        this.logger.debug(var10.getMessage());
                    }

                    this.cancelCookie(request, response);
                    return null;
                }
            }
        }

        protected String extractRememberMeCookie(HttpServletRequest request) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null && cookies.length != 0) {
                Cookie[] var3 = cookies;
                int var4 = cookies.length;

                for(int var5 = 0; var5 < var4; ++var5) {
                    Cookie cookie = var3[var5];
                    if (this.cookieName.equals(cookie.getName())) {
                        return cookie.getValue();
                    }
                }

                return null;
            } else {
                return null;
            }
        }

        protected Authentication createSuccessfulAuthentication(HttpServletRequest request, UserSecurityVO user) {
            RememberMeAuthenticationToken auth = new RememberMeAuthenticationToken(this.key, user, user.getAuthorities());
            auth.setDetails(getAuthenticationDetailsSource().buildDetails(request));
            auth.setAuthenticated(true);
            System.out.println("createSuccessfulAuthentication : 인증성공시 새로운 authenticaiton 등록||" + auth + " |||||| this key : " + this.key);
            return auth;
        }

        protected String[] decodeCookie(String cookieValue) throws InvalidCookieException {
            for(int j = 0; j < cookieValue.length() % 4; ++j) {
                cookieValue = cookieValue + "=";
            }

            try {
                Base64.getDecoder().decode(cookieValue.getBytes());
            } catch (IllegalArgumentException var7) {
                throw new InvalidCookieException("Cookie token was not Base64 encoded; value was '" + cookieValue + "'");
            }

            String cookieAsPlainText = new String(Base64.getDecoder().decode(cookieValue.getBytes()));
            String[] tokens = StringUtils.delimitedListToStringArray(cookieAsPlainText, ":");

            for(int i = 0; i < tokens.length; ++i) {
                try {
                    tokens[i] = URLDecoder.decode(tokens[i], StandardCharsets.UTF_8.toString());
                } catch (UnsupportedEncodingException var6) {
                    this.logger.error(var6.getMessage(), var6);
                }
            }

            return tokens;
        }

        protected String encodeCookie(String[] cookieTokens) {
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < cookieTokens.length; ++i) {
                try {
                    sb.append(URLEncoder.encode(cookieTokens[i], StandardCharsets.UTF_8.toString()));
                } catch (UnsupportedEncodingException var5) {
                    this.logger.error(var5.getMessage(), var5);
                }

                if (i < cookieTokens.length - 1) {
                    sb.append(":");
                }
            }

            String value = sb.toString();
            sb = new StringBuilder(new String(Base64.getEncoder().encode(value.getBytes())));

            while(sb.charAt(sb.length() - 1) == '=') {
                sb.deleteCharAt(sb.length() - 1);
            }

            return sb.toString();
        }

        public final void loginFail(HttpServletRequest request, HttpServletResponse response) {
            this.logger.debug("Interactive login attempt was unsuccessful.");
            this.cancelCookie(request, response);
            this.onLoginFail(request, response);
        }

        protected void onLoginFail(HttpServletRequest request, HttpServletResponse response) {
        }

        public final void loginSuccess(HttpServletRequest request, HttpServletResponse response, Authentication successfulAuthentication) {
            if (!this.rememberMeRequested(request, this.parameter)) {
                this.logger.debug("Remember-me login not requested.");
            } else {
                this.onLoginSuccess(request, response, successfulAuthentication);
            }
        }

        protected abstract void onLoginSuccess(HttpServletRequest var1, HttpServletResponse var2, Authentication var3);

        protected boolean rememberMeRequested(HttpServletRequest request, String parameter) {
            if (this.alwaysRemember) {
                return true;
            } else {
                String paramValue = request.getParameter(parameter);
                if (paramValue != null && (paramValue.equalsIgnoreCase("true") || paramValue.equalsIgnoreCase("on") || paramValue.equalsIgnoreCase("yes") || paramValue.equals("1"))) {
                    return true;
                } else {
                    if (this.logger.isDebugEnabled()) {
                        this.logger.debug("Did not send remember-me cookie (principal did not set parameter '" + parameter + "')");
                    }

                    return false;
                }
            }
        }

        protected abstract UserSecurityVO processAutoLoginCookie(String[] var1, HttpServletRequest var2, HttpServletResponse var3) throws RememberMeAuthenticationException, UsernameNotFoundException;

        protected void cancelCookie(HttpServletRequest request, HttpServletResponse response) {
            this.logger.debug("Cancelling cookie");
            Cookie cookie = new Cookie(this.cookieName, (String)null);
            cookie.setMaxAge(0);
            cookie.setPath(this.getCookiePath(request));
            if (this.cookieDomain != null) {
                cookie.setDomain(this.cookieDomain);
            }

            response.addCookie(cookie);
        }

        protected void setCookie(String[] tokens, int maxAge, HttpServletRequest request, HttpServletResponse response) {
            String cookieValue = this.encodeCookie(tokens);
            Cookie cookie = new Cookie(this.cookieName, cookieValue);
            cookie.setMaxAge(maxAge);
            cookie.setPath(this.getCookiePath(request));
            if (this.cookieDomain != null) {
                cookie.setDomain(this.cookieDomain);
            }

            if (maxAge < 1) {
                cookie.setVersion(1);
            }

            if (this.useSecureCookie == null) {
                cookie.setSecure(request.isSecure());
            } else {
                cookie.setSecure(this.useSecureCookie);
            }

            cookie.setHttpOnly(true);
            response.addCookie(cookie);
        }

        private String getCookiePath(HttpServletRequest request) {
            String contextPath = request.getContextPath();
            return contextPath.length() > 0 ? contextPath : "/";
        }

        public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
            if (this.logger.isDebugEnabled()) {
                this.logger.debug("Logout of user " + (authentication == null ? "Unknown" : authentication.getName()));
            }

            this.cancelCookie(request, response);
        }

        public void setCookieName(String cookieName) {
            Assert.hasLength(cookieName, "Cookie name cannot be empty or null");
            this.cookieName = cookieName;
        }

        public void setCookieDomain(String cookieDomain) {
            Assert.hasLength(cookieDomain, "Cookie domain cannot be empty or null");
            this.cookieDomain = cookieDomain;
        }

        protected String getCookieName() {
            return this.cookieName;
        }

        public void setAlwaysRemember(boolean alwaysRemember) {
            this.alwaysRemember = alwaysRemember;
        }

        public void setParameter(String parameter) {
            Assert.hasText(parameter, "Parameter name cannot be empty or null");
            this.parameter = parameter;
        }

        public String getParameter() {
            return this.parameter;
        }

    public IUserSecurityService getUserSecurityService() {
        return userSecurityService;
    }

    public String getKey() {
            return this.key;
        }

        public void setTokenValiditySeconds(int tokenValiditySeconds) {
            this.tokenValiditySeconds = tokenValiditySeconds;
        }

        protected int getTokenValiditySeconds() {
            return this.tokenValiditySeconds;
        }

        public void setUseSecureCookie(boolean useSecureCookie) {
            this.useSecureCookie = useSecureCookie;
        }

        protected AuthenticationDetailsSource<HttpServletRequest, ?> getAuthenticationDetailsSource() {
            return this.authenticationDetailsSource;
        }

        public void setAuthenticationDetailsSource(AuthenticationDetailsSource<HttpServletRequest, ?> authenticationDetailsSource) {
            Assert.notNull(authenticationDetailsSource, "AuthenticationDetailsSource cannot be null");
            this.authenticationDetailsSource = authenticationDetailsSource;
        }



}


