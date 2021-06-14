package com.seven.jong.repository;

import java.util.List;

import com.seven.jong.DTO.BoardDTO;

public interface IBoardMapper {
	public List<BoardDTO> boardAllList();

	public int writeSave(BoardDTO dto);
	
	public BoardDTO contentView(int writeNo);
}
