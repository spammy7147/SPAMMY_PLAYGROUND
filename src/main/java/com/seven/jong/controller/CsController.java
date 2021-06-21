package com.seven.jong.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.seven.jong.DTO.FaqDTO;
import com.seven.jong.DTO.QnaDTO;
import com.seven.jong.VO.UserVO;
import com.seven.jong.VO.security.UserSecurityVO;
import com.seven.jong.service.CsService;



@Controller
@RequestMapping("cs")
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
	
	
	//QnA연결
	@GetMapping("/customerqna")
	public String customerqna(@RequestParam(value="pageNum" , required=false, defaultValue="1") int pageNum, Model model) {
		cs.qna(pageNum,model);
		return "cs/customerQnA";
	}
	
	//QnA 컨텐츠 보기
	@GetMapping("/qnaview")
	public String qnaview(@RequestParam int qnaNo, Model model) {
		cs.qnaContentView(qnaNo, model);
		return "cs/qnaView";
	}
	
	//QnA 글쓰기
	@GetMapping("/qnawriteform")
	public String qnawriteform(@Nullable Authentication authentication, Model model) {
		UserSecurityVO userSecurityVO = (UserSecurityVO) authentication.getPrincipal();
		UserVO userVO = userSecurityVO.getUser();
		model.addAttribute("loginUser", userVO.getEmail());
		return "cs/qnaWriteForm";
	}
	//QnA저장
	@PostMapping("qnasave")
	public String qnaSave(@RequestParam(value="email") String email, 
			@RequestParam(value="title") String title, @RequestParam(value="content") String content, 
			 HttpServletRequest request) throws Exception {
		// MultipartHttpServletRequest mul,
		//cs.qnaSave(dto, mul, request);
		QnaDTO dto = new QnaDTO();
		dto.setEmail(email);
		dto.setTitle(title);
		dto.setContent(content);
		cs.qnaSave(dto, request);
		
		return "redirect:customerqna";
	}

}
