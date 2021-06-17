package com.seven.jong.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.seven.jong.DTO.BoardDTO;
import com.seven.jong.service.BoardService;

import oracle.jdbc.proxy.annotation.Post;

@Controller
@RequestMapping("board")
public class BoardContriller {
	@Autowired 
	BoardService bs;
	
	//boardAllList.jsp연결
	@GetMapping("/boardAllList")
	public String boardAllList(Model model, @RequestParam(value="num", required = false, defaultValue = "1") int num) {
		System.out.println("boardAllList연결");
		bs.boardAllList(model,num);
		return "board/boardAllList";
	}
	//writeForm.jsp 연결
	@GetMapping("/writeForm")
	public String writeForm() {
		return "board/writeForm";
	}
	//게시물 저장
	@PostMapping("/writeSave")
	public String writeSave(BoardDTO dto, HttpServletRequest request) {
		bs.writeSave(dto, request);
		return "redirect:/board/boardAllList";
	}
	//선택 게시물 보기
	@GetMapping("contentView")
	public String contentView (@RequestParam int writeNo, Model model ) {
		bs.contentView(writeNo, model);
		System.out.println("contentView연결");
		return "board/contentView";
	}
	//modifyForm 연결
	@GetMapping("modifyForm")
	public String modifyForm(@RequestParam int writeNo, Model model) {
		bs.contentView(writeNo, model);
		System.out.println("modifyForm 연결");
		return "board/modifyForm";
	}
	//게시물 수정
	@PostMapping("modify")
	public String modify(BoardDTO dto, HttpServletRequest request) {
		bs.modify(dto, request);
		return "redirect:/board/boardAllList";
	}
	//게시물 삭제
	@GetMapping("delete")
	public String delete(@RequestParam int writeNo) {
		bs.delete(writeNo);
		return "redirect:/board/boardAllList";
	}
	//게시물 검색
	@PostMapping("/boardSearch")
	public String userSearch(@RequestParam(value="num" , required=false, defaultValue="1") int num, @RequestParam("choice")String choice, @RequestParam("boardSearch")String search, Model model) {
		System.out.println("boardSearch연결");
	
		bs.boardSearch(num, choice ,search,model);
		return "board/boardSearch";
	}
}
















