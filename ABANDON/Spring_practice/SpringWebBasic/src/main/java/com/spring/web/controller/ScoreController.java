package com.spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.web.model.ScoreVO;
import com.spring.web.service.IScoreService;

@Controller
@RequestMapping("/score")
public class ScoreController {
	
	@Autowired
	private IScoreService service;
	
	//점수 등록 화면을 열어주는 메서드
	@GetMapping("/register")
	public String register() {
		System.out.println("/score/register : GET");
		
		return "score/write-form";
	}

	//점수 등록을 처리하는 요청 메서드
	@PostMapping("/register")
	public String register(ScoreVO score) {
		System.out.println("/score/register : POST");
		System.out.println("Controller param: " + score);
		service.insertScore(score);
		
		
		return "score/write-result";
	}
	
	
	@GetMapping("/list")
	public void list(Model model) {
		System.out.println("/score/list : GET");
		
		model.addAttribute("sList", service.selectAllScores());
	}

	@GetMapping("/delete")
	public String delete(int stuNum,RedirectAttributes rs) {
		
		service.deleteScore(stuNum);
		rs.addFlashAttribute("msg" , "delSuccess");
		return "redirect:/score/list";
	}
	
	
	
	@GetMapping("/search")
	public void search() {
		
	}
	
	@GetMapping("/selectOne")
	public String searchOne(@RequestParam("stuNum") String stuNum, Model model, RedirectAttributes rs) {
		int num=0;
		try {
			num = Integer.parseInt(stuNum);
		} catch (Exception e) {
			rs.addFlashAttribute("msg","숫자만 입력하세요");
			return "redirect:/score/search";
		}
		ScoreVO score = service.selectOne(num);
		if(score == null) {
			rs.addFlashAttribute("msg", "없는 학번입니다");
			return "redirect:/score/search";
		}else {
			
			model.addAttribute("score", score);
			return "/score/search-result";
		}

		
	}
	
	
	
	
}
