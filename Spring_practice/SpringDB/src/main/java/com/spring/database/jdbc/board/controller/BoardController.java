package com.spring.database.jdbc.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.database.jdbc.board.model.BoardVO;
import com.spring.database.jdbc.board.service.IBoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private IBoardService service;

	//글 작성 화면 요청
	@GetMapping("/write")
	public void write() {
		System.out.println("/board/write : GET요청 발생!");		
	}

	//글 작성 처리 요청
	@PostMapping("/write")
	public String write(BoardVO article) {
		System.out.println("/board/write : POST요청 발생!");
		service.insertArticle(article);
		return "redirect:/board/list";
	}

	//글 목록 화면 요청
	@GetMapping("/list")
	public void list(Model model) {
		System.out.println("/board/list : GET요청 발생!");
		model.addAttribute("articles", service.getArticles());		
	}

	//글 삭제 요청
	@GetMapping("/delete")
	public String delete(int boardNo) {
		System.out.println("/board/delete?boardNo="+boardNo+" : GET요청 발생!");
		service.deleteArticle(boardNo);
		return "redirect:/board/list";
	}

	//글 내용보기 요청
	@GetMapping("/content")
	public void content(int boardNo, Model model) {
		System.out.println("/board/content?boardNo="+boardNo+" : GET요청 발생!");

		model.addAttribute("article", service.getContent(boardNo));
		
	}

	//글 수정하기 화면요청
	@GetMapping("/modify")
	public void modify(int boardNo, Model model) {
		System.out.println("/board/modify?boardNo="+boardNo+" : GET요청 발생!");

		model.addAttribute("article", service.getContent(boardNo));
		
	}

	//글 수정 처리요청
	@PostMapping("/modify")
	public String modify(BoardVO article) {
		System.out.println("/board/modify?boardNo="+article.getBoardNo()+" : POST요청 발생!");
		service.modifyArticle(article);
		return "redirect:/board/content?boardNo="+article.getBoardNo();
	}
	
	//게시글 검색 처리요청
	@GetMapping("/searchList")
	public String searchList(String keyword, Model model) {
		List<BoardVO> list = service.getSearchList(keyword);		
		model.addAttribute("articles", list);
		return "board/list";
	}

}






