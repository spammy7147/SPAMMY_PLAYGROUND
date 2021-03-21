package com.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.web.model.UserVO;

@Controller
@RequestMapping("/response")
public class ResponseController {
	
	
	@GetMapping("/res-ex01")
	public void resEx01() {
		
	}
	//1번쨰 RequestParam + Model
	//model 객체를 사용하여 화면에 데이터 전송하기
//	@GetMapping("/test")
//	public void test(@RequestParam("age") int age,Model model) {
//		model.addAttribute("nick", "뽀삐");
//		model.addAttribute("age", age);
//	}
	
	//2번쨰 ModelAttribute 객체를 활용한 처리
	@GetMapping("/test")
	public void test(@ModelAttribute("age") int age,Model model) {
		model.addAttribute("nick", "뽀삐");
		//model.addAttribute("age", age);
	}
	
	//3번쨰 ModelAndView 객체를 활용한 처리
	
	@GetMapping("/test2")
	public ModelAndView test2() {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("userName","박영희");
		mv.setViewName("/response/test2");
	
		//return mv;
		return new ModelAndView("/response/test2", "userName","박영희" );
	}
	
	
	//res-ex02.jsp
	@GetMapping("/res-ex02")
	public void resEx02() {
		
		
	}
	
	@PostMapping("/join")
	public String join(@ModelAttribute("user") UserVO user) {
	
		//model.addAttribute("user",user);
		
		return "/response/test3";
	}
	

	///////////////////////////////////////////////////////////
	
	
	//redirect 처리
	//로그인 화면 요청 처리
	
	@GetMapping("/login")
	public String login() {
		System.out.println("/login : GET 요청 발생??이게왜");
		return "response/res-redirect-form";
	}
	
	//로그인 검증
	@PostMapping("/login")
	public String login(@ModelAttribute("userId") String id,
						@RequestParam("userPw") String pw,
						@RequestParam("userPwChk") String pwChk,
						RedirectAttributes rs){
		
		System.out.println("/login : POST 요청 발생");
		System.out.println("ID : " + id);
		System.out.println("PW : " + pw);
		System.out.println("PWChk : " + pwChk);
	
		if (id.equals("")) {
			
		//	model.addAttribute("msg","아이디는 필수값이에요");
		//	session.setAttribute("msg","아이디는 필수값이에요");
		rs.addFlashAttribute("msg","아이디는 필수값이에요");
			return "redirect:/response/login";
		}else if (!pw.equals(pwChk)) {
			
		//	model.addAttribute("msg", "비밀번호 확인란을 확인하세요");
		//	session.setAttribute("msg","비밀번호 확인란을 확인하세요");
		rs.addFlashAttribute("msg","비밀번호 확인란을 확인하세요");
			return "redirect:/response/login";
		}else if(id.equals("abc123") && pw.equals("1234")) {
			System.out.println("아이디비번일치");
			return "response/res-ex01";
		}

		return null;
	}
	
	
	
	
}
