package com.seven.jong.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seven.jong.DTO.BoardReplyDTO;
import com.seven.jong.service.BoardService;

@RestController
@RequestMapping("/board")
public class BoardReplyController {
	@Autowired BoardService bs;
	
	@PostMapping(value = "addReply", produces = "application/json; charset=utf-8")
	public void addReply(@RequestBody Map<String, Object> map){//세션 추가해야함
		System.out.println(map);
		BoardReplyDTO rDto = new BoardReplyDTO();
		rDto.setWriter((String)map.get("writer"));
		rDto.setWrite_group(Integer.parseInt((String)map.get("write_no")));
		rDto.setContent((String)map.get("content"));
	
		bs.addReply(rDto);
	}
}
