package com.spring.wow.commons.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class BoardInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("게시판 인터셉터 발동!");
		HttpSession session = request.getSession();
		
		if(session.getAttribute("login") == null ) {
			System.out.println("회원인증 실패!");
			//response.sendRedirect("/");
			
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			String element = "<script>"
							+"alert('로그인을 해야해요!');"
							+"location.href='/';"
							+"</script>";
			out.print(element);
			out.flush();
			out.close();
			
			
			return false;
		}
		
		return true;
	}
}
