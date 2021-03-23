package com.spammy.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spammy.hello.model.BoardVO;
import com.spammy.hello.service.IBoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private IBoardService bs;
	
	//////// write ///////////
	@GetMapping("/write")
	public String write() {
		return "/board/write";
	}
	@PostMapping("/write")
	public String write(BoardVO article) {
	bs.insertArticle(article);	
		return "redirect:/board/list";
	}
	
	//////// list ///////////
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("articles",bs.getArticles());
		return "/board/list";
	}
	
	////////delete ///////////
	@GetMapping("/delete")
	public String delete(int boardNum) {
		
		bs.deleteArticle(boardNum);
		return "redirect:/board/list";
	}
	
	//////// content ///////////
	@GetMapping("/content")
	public String content(int boardNum, Model model) {
		model.addAttribute("article",bs.getContent(boardNum));
		model.addAttribute("boardNo",boardNum);
		return "/board/content";
	}
	
	////////modify ///////////
	@GetMapping("/modify")
	public String modify(int boardNo, Model model) { // @ModelAttribute("boardNo") 해서 배로 모델로 넘겨줄 수 있다
		model.addAttribute("article",bs.getContent(boardNo));
		model.addAttribute("boardNo",boardNo);
		return "/board/modify";
	}
	@PostMapping("/modify")
	public String modify(int boardNo, BoardVO article) {
		bs.modifyArticle(article, boardNo);
		System.out.println("흠 수정 요청 들어옴");
		return "redirect:/board/content?boardNum="+boardNo;
	}

	@GetMapping("/test")
	public String test(@ModelAttribute("NO") int no) {
		System.out.println(no);
		return "/board/test";
	}
	
}
