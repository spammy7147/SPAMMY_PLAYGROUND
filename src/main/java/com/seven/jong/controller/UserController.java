package com.seven.jong.controller;

import com.seven.jong.DTO.UserRequestDTO;
import com.seven.jong.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	IUserService userService;


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
		System.out.println("login연결");
		return "user/login";
	}
}
