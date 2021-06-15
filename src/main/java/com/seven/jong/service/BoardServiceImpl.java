package com.seven.jong.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.seven.jong.DTO.BoardDTO;
import com.seven.jong.repository.IBoardMapper;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	IBoardMapper mapper;
	
	@Override
	public void writeSave(BoardDTO dto, HttpServletRequest request) {
		dto.setTitle(request.getParameter("title"));
		dto.setWriter(request.getParameter("writer"));
		dto.setContent(request.getParameter("content"));
		
		mapper.writeSave(dto);
	}

	@Override
	public void boardAllList(Model model) {
		model.addAttribute("boardList",mapper.boardAllList());
		
	}

	@Override
	public void contentView(int writeNo, Model model) {
		model.addAttribute("contentData",mapper.contentView(writeNo));
		upHit(writeNo);
	}
	private void upHit(int writeNo) {
		mapper.upHit(writeNo);
	}

	@Override
	public void modify(BoardDTO dto, HttpServletRequest request) {
		
		dto.setWriteNo(Integer.parseInt(request.getParameter("writeNo")));
		
		dto.setTitle(request.getParameter("title"));
		dto.setContent(request.getParameter("content"));
		
		mapper.modify(dto);
	}
}
