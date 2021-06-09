package com.seven.jong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String home() {
        System.out.println("home 진입");
        return "home";
    }

    @GetMapping("hello")
    public String hello() {
        System.out.println("hello 진입");
        return "hello";
    }
}