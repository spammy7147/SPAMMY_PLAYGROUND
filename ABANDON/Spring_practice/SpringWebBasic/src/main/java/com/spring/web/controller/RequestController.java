package com.spring.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.web.model.UserVO;



// servlet-config.xml 에서 빈등록이 필요하지만 자동으로 빈등록 아노테이션 사용해도된다
@RequestMapping("/request")
@Controller //자동으로 스프링 컨터이너에 빈등록하는 아노테이션
public class RequestController {

	public RequestController() {
		System.out.println("리퀘스트 컨트롤러 작동");
	}
	
	//requestMapping 은 어떤 URI로 메서드를 동작시킬것인가에 대한 설정
	@RequestMapping("/test")
	public String testCall() {
		System.out.println("/requet/test 요청이 들어옴!!");
		return "test";
	}
	@RequestMapping("/req")
	public String rq_ex01() {
		System.out.println("/request/rq_ex01.jsp 오픈?");
		return "/request/rq_ex01";
	}
	//@GetMapping("/request/basic01")
	@RequestMapping(value="/basic01",method=RequestMethod.GET)
	public String basicGet() {
		
			System.out.println("/request/basic01 요청이 들어옴 : GET");
		return "/request/rq_ex01";
	}
	
	//@PostMapping("/request/basic01")
	@RequestMapping(value="/basic01",method=RequestMethod.POST)
	public String basicPost() {
		
			System.out.println("/request/basic01 요청이 들어옴 : post");
		return "/request/rq_ex01";
	}
	
	//컨트롤러의 요청메서드를 void 리턴타입으로 지정
	
	@GetMapping("/req-ex02")
	public void reqEx02() {
		System.out.println("/request/req-ex02 요청!");
	}
	
	//요청 파라미터 받아보기
	@GetMapping("/param")
	public String paramTest(HttpServletRequest request) {
		
		System.out.println("/request/param 요청:GET");
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println("이름 : " +   name );
		System.out.println("나이 : " + age );
		
		return "";
	}
	
	
	///////////////////////////////////////////////////////////
	@GetMapping("/join")
	public void register() {
		System.out.println("/request/join : GET" );
	}
	
	
	/*
	 
	 1. jsp/servlet의 파라미터 읽기 처리방법
	 - HttpServletRequest 객체를 사용
	 
	//첫번쨰
	@PostMapping("/join")
	public String register(HttpServletRequest request) {
		
		System.out.println("/request/join : POST");
		
		System.out.println("ID = " + request.getParameter("userId"));
		System.out.println("PW = " + request.getParameter("userPw"));
		System.out.println("HOBBY = " + Arrays.toString(request.getParameterValues("hobby")));

		
		return "request/join";
	}
	
	 */


	/*
	  
	 @RequestParam 어노테이션을이용한 요청 파라미터 처리

	 */
	
	/*

	//두번쨰
	@PostMapping("/join")
	public void register(@RequestParam("userId") String id,
						 @RequestParam("userPw") String pw,
						 @RequestParam(value="hobby",required=false,defaultValue="no hobby person") List<String> hobbys){
		
		System.out.println("ID : " + id);
		System.out.println("PW : " + pw);
		System.out.println("HOBBY : " + hobbys);
		
	}
	
	*/
	
	
	/*
	 3. 커맨드 객체를 활용한 파라미터 처리
	 */
	@PostMapping("/join")
	public void register(UserVO user) {
		
		System.out.println(user.getUserId());
		System.out.println(user.getUserPw());
		System.out.println(user.getUserName());
		System.out.println(user.getHobby());
		
	}
	
	@PostMapping("/quiz")
	public String registerquiz(UserVO user) {
		if(user.getUserId().equals("abc1234")) {
			if(user.getUserPw().equals("xxx4321")) {
				return "/request/login-success";
			}
		}
		
		return "/request/login-fail";
	}
	@GetMapping("/quiz")
	public String registerquiz() {
		
		return "/request/req-quiz";
	}
	
	
	
	
	
	
}
