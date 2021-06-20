package com.seven.jong.service.security;


import com.seven.jong.VO.security.PersistentTokenVO;
import com.seven.jong.VO.security.UserSecurityVO;
import com.seven.jong.repository.IPersistentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.rememberme.CookieTheftException;
import org.springframework.security.web.authentication.rememberme.InvalidCookieException;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.authentication.rememberme.RememberMeAuthenticationException;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;


public class test extends CustomRememberMeServices {

    private PersistentTokenRepository tokenRepository;
    private SecureRandom random = new SecureRandom();
    public static final int DEFAULT_SERIES_LENGTH = 16;
    public static final int DEFAULT_TOKEN_LENGTH = 16;
    private int seriesLength = 16;
    private int tokenLength = 16;
    IPersistentMapper persistentMapper;

    @Autowired
    public void setPersistentMapper(IPersistentMapper persistentMapper) {
        this.persistentMapper = persistentMapper;
    }

    public test(String key, IUserSecurityService userSecurityService) {
        super(key, userSecurityService);
    }


    protected UserSecurityVO processAutoLoginCookie(String[] cookieTokens, HttpServletRequest request, HttpServletResponse response) {
        if (cookieTokens.length != 2) {
            throw new InvalidCookieException("Cookie token did not contain 2 tokens, but contained '" + Arrays.asList(cookieTokens) + "'");
        } else {

            String presentedKey = cookieTokens[0];
            String presentedToken = cookieTokens[1];
            PersistentTokenVO token = persistentMapper.getTokenForKey(presentedKey);
            if (token == null) {
                throw new RememberMeAuthenticationException("No persistent token found for series id: " + presentedKey);
            } else if (!presentedToken.equals(token.getToken())) {
                persistentMapper.removeUserTokens(token.getUserId());
                throw new CookieTheftException(this.messages.getMessage("PersistentTokenBasedRememberMeServices.cookieStolen", "Invalid remember-me token (Series/token) mismatch. Implies previous cookie theft attack."));
            } else if (Date.from(token.getLastUsed().atZone(ZoneId.systemDefault()).toInstant()).getTime() + (long)this.getTokenValiditySeconds() * 1000L < System.currentTimeMillis()) {
                throw new RememberMeAuthenticationException("Remember-me login has expired");
            } else {
                if (this.logger.isDebugEnabled()) {
                    this.logger.debug("Refreshing persistent login token for user '" + token.getUserId() + "', series '" + token.getKey() + "'");
                }

                PersistentTokenVO newToken = new PersistentTokenVO(token.getUserId(), token.getKey(), this.generateTokenData(), LocalDateTime.now());
                System.out.println("자동로그인  새로운 토큰 발급 " + newToken);
                try {
                    persistentMapper.updateToken(newToken);
                    this.addCookie(newToken, request, response);
                } catch (Exception var9) {
                    System.out.println("Failed to update token: ");
                    throw new RememberMeAuthenticationException("Autologin failed due to data access problem");
                }
                System.out.println("precessautologin 정상 처리 완료");
                UserSecurityVO user = getUserSecurityService().loadUserById(token.getUserId());
                System.out.println(user);
                return user;
            }
        }
    }


    protected void onLoginSuccess(HttpServletRequest request, HttpServletResponse response, Authentication successfulAuthentication) {

        try {
            Integer userId =((UserSecurityVO)successfulAuthentication.getPrincipal()).getUser().getUserId();
            System.out.println("Creating new persistent login for user " + userId);
            PersistentTokenVO newToken = new PersistentTokenVO(userId, this.generateSeriesData(), this.generateTokenData(), LocalDateTime.now());

            persistentMapper.createNewToken(newToken);
            this.addCookie(newToken, request, response);
        } catch (Exception var7) {
            System.out.println("Failed to save persistent token ");
            System.out.println(var7.getMessage());
        }

    }



    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        super.logout(request, response, authentication);
        if (authentication != null) {
            persistentMapper.removeUserTokens(((UserSecurityVO)authentication.getPrincipal()).getUser().getUserId());
        }

    }

    protected String generateSeriesData() {
        byte[] newSeries = new byte[this.seriesLength];
        this.random.nextBytes(newSeries);
        return new String(Base64.getEncoder().encode(newSeries));
    }

    protected String generateTokenData() {
        byte[] newToken = new byte[this.tokenLength];
        this.random.nextBytes(newToken);
        return new String(Base64.getEncoder().encode(newToken));
    }

    private void addCookie(PersistentTokenVO token, HttpServletRequest request, HttpServletResponse response) {
        this.setCookie(new String[]{token.getKey(), token.getToken()}, this.getTokenValiditySeconds(), request, response);
    }

    public void setSeriesLength(int seriesLength) {
        this.seriesLength = seriesLength;
    }

    public void setTokenLength(int tokenLength) {
        this.tokenLength = tokenLength;
    }

    public void setTokenValiditySeconds(int tokenValiditySeconds) {
        Assert.isTrue(tokenValiditySeconds > 0, "tokenValiditySeconds must be positive for this implementation");
        super.setTokenValiditySeconds(tokenValiditySeconds);
    }
}

