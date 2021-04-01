package com.spring.wow.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.wow.board.model.BoardVO;
import com.spring.wow.board.service.IBoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private IBoardService service;
	
	//게시글 불러오기 요청
	@GetMapping("/list")
	public String list(Model model) {
		List<BoardVO> list = service.getArticleList();
		System.out.println("URL : /board/list GET -> result: " + list.size());
		//list.forEach(article -> System.out.println(article));
		model.addAttribute("articles",list);
		return "/board/list";
	}
}
