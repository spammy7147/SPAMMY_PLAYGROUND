package com.seven.jong.controller;

import com.seven.jong.DTO.UserRequestDTO;
import com.seven.jong.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("user")
public class UserController {

	IUserService userService;

	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@GetMapping("/register")
	public String register() {
		System.out.println("register => GET 요청");
		return "user/register";
	}
	
	@PostMapping("/register")
	public String register(UserRequestDTO user) {
		System.out.println("register => POST 요청");
		userService.addUser(user);
		return "user/register";
	}
	@GetMapping("/login")
	public String login() {
		System.out.println("login => GET 요청");
		return "user/login";
	}

	@PostMapping("/login")
	public void login(HttpServletRequest request) {
		System.out.println("login => POST 요청");

		String uri = request.getHeader("Referer"); //결국 레퍼러의 값은 이 페이지를 요청한 이전 페이지가 무엇인지를 알려준다. 레퍼러는 로그분석을 위해서 유저의 자취를 분석하는데 요긴한 정보이다.

		if(uri != null){
			if (!uri.contains("/user/login")) {
				request.getSession().setAttribute("prevPage", uri);
			}
		}
		System.out.println("Referer : " + uri);
	}

	@PostMapping("/logout")
	public void logout(){
	}
}
