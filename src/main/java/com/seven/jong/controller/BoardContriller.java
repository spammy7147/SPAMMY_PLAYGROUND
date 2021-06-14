package com.seven.jong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("board")
public class BoardContriller {
	@GetMapping("boardAllList")
	public String boardAllList() {
		System.out.println("boardAllList연결");
		return "board/boardAllList";
	}
	@GetMapping("writeForm")
	public String writeForm() {
		return "board/writeForm";
	}
}
