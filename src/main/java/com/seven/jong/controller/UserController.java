package com.seven.jong.controller;

import com.seven.jong.DTO.UserRequestDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {


	@GetMapping("/register")
	public String register() {
		System.out.println("register연결");
		return "user/register";
	}
	@PostMapping("/register")
	public String register(UserRequestDTO user) {
		System.out.println(user);
		return "user/register";
	}

	@GetMapping("/login")
	public String login() {
		System.out.println("login연결");
		return "user/login";
	}
}
