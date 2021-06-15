package com.seven.jong.service.security;

import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class UserLoginFailHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

        if (e instanceof AuthenticationServiceException) {
            httpServletRequest.setAttribute("loginFailMsg", "존재하지 않는 사용자입니다.");

        } else if(e instanceof BadCredentialsException) {
            httpServletRequest.setAttribute("loginFailMsg", "아이디 또는 비밀번호가 틀립니다.");

        } else if(e instanceof LockedException) {
            httpServletRequest.setAttribute("loginFailMsg", "잠긴 계정입니다..");

        } else if(e instanceof DisabledException) {
            httpServletRequest.setAttribute("loginFailMsg", "비활성화된 계정입니다..");

        } else if(e instanceof AccountExpiredException) {
            httpServletRequest.setAttribute("loginFailMsg", "만료된 계정입니다..");

        } else if(e instanceof CredentialsExpiredException) {
            httpServletRequest.setAttribute("loginFailMsg", "비밀번호가 만료되었습니다.");
        }

        // 로그인 페이지로 다시 포워딩
        RequestDispatcher dispatcher = httpServletRequest.getRequestDispatcher("/user/login");
        dispatcher.forward(httpServletRequest, httpServletResponse);
    }

}
