package com.seven.jong.service;

import javax.servlet.http.HttpServletRequest;

import com.seven.jong.DTO.BoardDTO;

public interface BoardService {
	public void writeSave(BoardDTO dto,HttpServletRequest request);
}
