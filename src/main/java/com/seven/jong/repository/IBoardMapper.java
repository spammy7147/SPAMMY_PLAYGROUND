package com.seven.jong.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.seven.jong.DTO.BoardDTO;

public interface IBoardMapper {
	public List<BoardDTO> boardAllList(@Param("s")int start,@Param("e")int end);

	public int writeSave(BoardDTO dto);
	
	public BoardDTO contentView(int writeNo);
	
	public void upHit(int writeNo);

	public void modify(BoardDTO dto);

	public void delete(int writeNo);

	public int selectBoardCount();
}
