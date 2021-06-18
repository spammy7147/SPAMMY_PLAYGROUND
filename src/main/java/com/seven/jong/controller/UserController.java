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

	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		System.out.println("login => 요청");

		String uri = request.getHeader("Referer");
		if(uri != null){
			if (!uri.contains("/user/login")) {
				request.getSession().setAttribute("prevPage", uri);
			}
		}
		System.out.println("Referer : " + uri);
		return "user/login";
	}

	@PostMapping("/logout")
	public void logout(){
	}
}
