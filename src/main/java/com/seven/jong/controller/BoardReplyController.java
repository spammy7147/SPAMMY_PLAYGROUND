package com.seven.jong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.seven.jong.DTO.BoardReplyDTO;
import com.seven.jong.service.BoardService;

@RestController
@RequestMapping("/board")
public class BoardReplyController {
	@Autowired BoardService bs;
	
	@GetMapping(value = "replyData/{write_group}", produces = "application/json; charset=utf-8" )
    public List<BoardReplyDTO> replyData(@PathVariable int write_group){
		return bs.getReplyList(write_group);
    }
	
	

}
















