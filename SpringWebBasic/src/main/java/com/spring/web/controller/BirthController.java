package com.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.web.model.BirthVO;

@Controller
@RequestMapping("/birth")
public class BirthController {

	
	
	//생일을 입력하는 폼을 열어주는 요청 메서드
	@GetMapping("/birthform")
	public String birthForm() {
		
		return "/birth/birth-form";
	}
	
	@PostMapping("/birth-result")
	public void birthCheck(@ModelAttribute("birth") BirthVO birth) {
		
	}
	
	
}
