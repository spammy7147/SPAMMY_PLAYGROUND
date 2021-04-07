package com.spring.wow.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.wow.board.model.BoardVO;
import com.spring.wow.board.service.IBoardService;
import com.spring.wow.commons.PageVO;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private IBoardService service;
	
//	//게시글 불러오기 요청
//	@GetMapping("/list")
//	public String list(Model model) {
//		List<BoardVO> list = service.getArticleList();
//		System.out.println("URL : /board/list GET -> result: " + list.size());
//		//list.forEach(article -> System.out.println(article));
//		model.addAttribute("articles",list);
//		return "/board/list";
//	}
	
	
	//게시글 불러오기 요청
	@GetMapping("/list")
	public String list(PageVO page,Model model) {
		List<BoardVO> list = service.getArticleListPaging(page);
		System.out.println("URL : /board/list GET -> result: " + list.size());
		System.out.println("page 정보 : " + page);
		model.addAttribute("articles",list);
		return "/board/list";
	}
	
	//게시글 작성페이지 요청
	@GetMapping("/write")
	public String write() {
		System.out.println("URL : /board/write => GET");
		return "/board/write";
	}
	// 게시글 DB 등록 요청
	@PostMapping("/write")
	public String write(RedirectAttributes r, BoardVO article) {
		service.insert(article);
		r.addFlashAttribute("msg", "regSuccess");
		System.out.println("URL : /board/write => POST");
		System.out.println("Controller parameter : " + article);
		return "redirect:/board/list";
	}
	
	//게시글 상세보기
	@GetMapping("/content/{boardNo}")
	public String content(@PathVariable Integer boardNo, Model model) {
		System.out.println("URL : /board/content => GET");
		System.out.println("boardNo : " + boardNo + " 게시물");
		model.addAttribute("article", service.getArticle(boardNo));
		return "/board/content";
	}
	
	//게시글 삭제
	@PostMapping("/delete")
	public String delete(Integer boardNo, RedirectAttributes r) {
		System.out.println("URL : /board/delete => POST");
		System.out.println("parameter : " + boardNo);
		service.delete(boardNo);
		r.addFlashAttribute("msg", "delSuccess");
		return "redirect:/board/list";
	}
	
	//게시글 수정
	@GetMapping("/modify")
	public String modify(Integer boardNo, Model model) {
		System.out.println("URL : /board/modify => GET");
		System.out.println("parameter : " + boardNo);
		model.addAttribute("article",service.getArticle(boardNo));
		return "/board/modify";
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO article, RedirectAttributes r) {
		System.out.println("URL : /board/modify => POST");
		System.out.println("Parameter(게시글): " + article);
		service.update(article);
		
		r.addFlashAttribute("msg", "modSuccess");
		return "redirect:/board/content/"+article.getBoardNo();
	}
	
	
	
}
