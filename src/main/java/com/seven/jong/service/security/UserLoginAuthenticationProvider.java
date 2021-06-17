package com.seven.jong.service.security;

import com.seven.jong.VO.security.UserSecurityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserLoginAuthenticationProvider implements AuthenticationProvider {

    // DB의 값을 가져다주는 커스터마이징 클래
    IUserSecurityService userSecurityService;
    // 패스워드 암호화 객체
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public void setbCryptPasswordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    @Autowired
    public void setUserSecurityService(IUserSecurityService userSecurityService) {
        this.userSecurityService = userSecurityService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        /* 사용자가 입력한 정보 */
        String userId = authentication.getName();
        String userPw = (String) authentication.getCredentials();

        /* DB에서 가져온 정보  */
        UserSecurityVO user = userSecurityService.loadUserByEmail(userId);

        /* 인증 진행 */
        if (user == null ||
            !userId.equals(user.getEmail()) ||
            !bCryptPasswordEncoder.matches(userPw, user.getPassword())) {

            throw new BadCredentialsException(userId);

        } else if (user.getIsAccountLocked()) {
            throw new LockedException(userId);
        }

        // 다 썼으면 패스워드 정보는 지워줌 (객체를 계속 사용해야 하므로)
        user.deletePassword();

        /* 최종 리턴 시킬 새로만든 Authentication 객체 */
        return new UsernamePasswordAuthenticationToken(
                user, null, user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }


}
