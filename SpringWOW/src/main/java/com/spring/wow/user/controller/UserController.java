package com.spring.wow.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.wow.user.model.UserVO;
import com.spring.wow.user.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService service;
	
	//회원가입 요청 처리
	// Rest-api INSERT -> POST
	@PostMapping("/")
	public String register(@RequestBody UserVO user) {
		System.out.println("/user/ POST 요청 발생!");
		System.out.println("param:" + user);
		
		service.register(user);
		return "joinSuccess";
	}
	
	@PostMapping("/checkId")
	public String checkId(@RequestBody String account) {
		System.out.println("/user/checkId : POST 요청 발생!");
		System.out.println("parameter :" + account);
		String result = null;
		
		Integer checkNum = service.checkId(account);
		if(checkNum == 1) {
			System.out.println("아이디가 중복됨!");
			result="NO";
		}else {
			System.out.println("아이디 사용가능!");
			result="OK";
		}
		return result;
	}
	
	//로그인 요청 처리
	@PostMapping("/loginCheck")
	public String loginCheck(@RequestBody UserVO user) {
		
		System.out.println("/login : POST 요청 발생!");
		System.out.println("param : " + user);
		
		/*
		 
		 #클라이언트가 전송한 id값과 pw값을 가지고 DB에서 회원의 정보를 조회해서 불러온다음 값 비교를 통해 
		 1. 아이디가 벗을 경우 클라이언트 측으로 문자열 "idFail" 전송
		 2. 비밀번호가 틀렸을 경우 문자열 "pwFail" 전송
		 3. 로그인 성공시 문자열 "loginSuccess" 전송
		 
		 */
		
		String result = service.login(user);
		
		return result;
	}
	
	
	//회원탈퇴 요청 처리
	//@RequestMapping(value="/", method=RequestMethod.DELETE)
	@DeleteMapping("/{account}")
	public String delete(@PathVariable String account) {
		
		System.out.println("/user/"+account+ " DELETE 요청 발생!");
		System.out.println("param:" + account);
		
		service.delete(account);
		
		return "delSuccess";
	}
	
	//회원정보 조회
	@GetMapping("/{account}")
	public UserVO select(@PathVariable String account) {

		System.out.println("/user/"+account+ " GET 요청 발생!");
		System.out.println("param:" + account);
		
		return service.select(account);
	}
	
	//회원 전체 정보 조회
	@GetMapping("/")
	public List<UserVO> selectAll(){
		System.out.println("/user/"+ " GET 요청 발생!");
		return service.selectAll();
	}

}
