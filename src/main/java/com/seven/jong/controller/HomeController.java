package com.seven.jong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
    public String home() {
        System.out.println("main 진입");
        return "home";
    }
}
