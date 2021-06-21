package com.seven.jong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.seven.jong.DTO.FaqDTO;
import com.seven.jong.service.CsService;

@Controller
public class CsController {
	@Autowired CsService cs;

	//고객센터(자주하는 질문)
	@GetMapping("/customerservice")
	public String customerService01(Model model) {
		cs.faq(model);
		return "cs/customerService";
	}	
	//FAQ(자주하는 질문)추가하기
	@PostMapping(value="/addFaq")
	public String addFaq(@RequestParam(value="title") String title, @RequestParam(value="content") String content) {
		FaqDTO dto = new FaqDTO();
		dto.setQuestion(title);
		dto.setAnswer(content);
		
		cs.addFaq(dto);
		return "redirect:customerservice";
	}
	//FAQ 질문 삭제
	@PostMapping(value="/delFaq")
	public String selFaq(@RequestParam(value="faqNum") int faqNum) {
		
		cs.delFaq(faqNum);
		return "redirect:customerservice";
	}
	//고객센터(문의하기)
	@GetMapping("/customerqna")
	public String customerqna() {
		return "cs/customerQnA";
	}

}
