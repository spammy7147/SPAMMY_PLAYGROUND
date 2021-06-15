package com.seven.jong.service.auth;

import com.seven.jong.DTO.UserRequestDTO;
import com.seven.jong.VO.UserVO;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class UserLoginAuthenticationProvider implements IUserLoginAuthenticationProvider, AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        /* 사용자가 입력한 정보 */
        String email = authentication.getName();
        String password = (String) authentication.getCredentials();


        /* DB에서 가져온 정보 (커스터마이징 가능) */
//        UserVO user = (UserVO) userDetailsServcie
//                .loadUserByUsername(userId);
        Authentication newAuth = new UsernamePasswordAuthenticationToken(new UserRequestDTO(),null);

        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
