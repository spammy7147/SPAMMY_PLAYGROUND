package com.spring.wow.commons.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.WebUtils;

import com.spring.wow.user.model.UserVO;
import com.spring.wow.user.service.IUserService;

public class AutoLoginInterceptor implements HandlerInterceptor{
	
	@Autowired
	IUserService service;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//1. 자동 로그인 쿠키가 있는지 여부 확인
		// - 쿠키(loginCookie)의 존재 여부 확인
		
		Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
		
		if(loginCookie != null) { //자동 로그인 true
			UserVO user = service.getUserWithSessionId(loginCookie.getValue());
			if(user != null) {
				request.getSession().setAttribute("login", user);
			}
		}
		
		return true;
	}
}
