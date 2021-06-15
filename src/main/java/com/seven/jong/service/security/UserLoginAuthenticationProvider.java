package com.seven.jong.service.security;

import com.seven.jong.VO.security.UserSecurityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserLoginAuthenticationProvider implements AuthenticationProvider {

    // DB의 값을 가져다주는 커스터마이징 클래스
    @Autowired
    UserDetailsService userDetailsService;

    // 패스워드 암호화 객체
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {



        /* 사용자가 입력한 정보 */
        String userId = authentication.getName();
        String userPw = (String) authentication.getCredentials();

        /* DB에서 가져온 정보 (커스터마이징 가능) */
        UserSecurityVO user = (UserSecurityVO) userDetailsService
                .loadUserByUsername(userId);



        /* 인증 진행 */

        // DB에 정보가 없는 경우 예외 발생 (아이디/패스워드 잘못됐을 때와 동일한 것이 좋음)
        // ID 및 PW 체크해서 안맞을 경우 (matches를 이용한 암호화 체크를 해야함)
        if (user == null || !userId.equals(user.getEmail())
                || !bCryptPasswordEncoder.matches(userPw, user.getPassword())) {

            throw new BadCredentialsException(userId);

            // 계정 정보 맞으면 나머지 부가 메소드 체크 (이부분도 필요한 부분만 커스터마이징 하면 됨)
            // 잠긴 계정일 경우
        } else if (!user.isAccountNonLocked()) {
            throw new LockedException(userId);

            // 비활성화된 계정일 경우
        } else if (!user.isEnabled()) {
            throw new DisabledException(userId);

            // 만료된 계정일 경우
        } else if (!user.isAccountNonExpired()) {
            throw new AccountExpiredException(userId);

            // 비밀번호가 만료된 경우
        } else if (!user.isCredentialsNonExpired()) {
            throw new CredentialsExpiredException(userId);
        }

        // 다 썼으면 패스워드 정보는 지워줌 (객체를 계속 사용해야 하므로)
        user.setPassword(null);

        /* 최종 리턴 시킬 새로만든 Authentication 객체 */
        Authentication newAuth = new UsernamePasswordAuthenticationToken(
                user, null, user.getAuthorities());

        return newAuth;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
