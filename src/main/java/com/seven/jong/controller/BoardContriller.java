package com.seven.jong.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seven.jong.DTO.BoardDTO;
import com.seven.jong.service.BoardService;

@Controller
@RequestMapping("board")
public class BoardContriller {
	@Autowired 
	BoardService bs;
	
	@GetMapping("/boardAllList")
	public String boardAllList() {
		System.out.println("boardAllList연결");
		return "board/boardAllList";
	}
	@GetMapping("/writeForm")
	public String writeForm() {
		return "board/writeForm";
	}
	@PostMapping("/writeSave")
	public String writeSave(BoardDTO dto, HttpServletRequest request) {
		bs.writeSave(dto, request);
		return "board/boardAllList";
	}
}
