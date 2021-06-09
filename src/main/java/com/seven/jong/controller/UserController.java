package com.seven.jong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member")
public class UserController {
	@GetMapping("/register")
	public String register() {
		System.out.println("register연결");
		return "member/register";
	}
	@GetMapping("/login")
	public String login() {
		System.out.println("login연결");
		return "member/login";
	}
}
