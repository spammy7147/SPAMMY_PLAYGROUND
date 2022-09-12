package com.spring.wow.commons.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TestInterceptor implements HandlerInterceptor{
	
	
	//preHandle은 특정 컨트롤러에 진입하기 전에 공통처리할 내용을 작성
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		System.out.println("테스트 인터셉터의 preHandle이 작동!");
		
		return true; //true 가 리턴되면 컨트롤러로 진입 false가 리턴되면 실패
	}

	
	//postHandle 은 컨트롤러를 나갈때 공통처리해야할 내용을 작성!
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("테스트 인터셉터의 postHandle 작동!!");
		Object data = modelAndView.getModel().get("data");
		if(data!=null) {
			request.getSession().setAttribute("data", data);
			response.sendRedirect("/test1");
		}
		
	
	}
	
}
