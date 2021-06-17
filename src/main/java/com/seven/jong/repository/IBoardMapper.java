package com.seven.jong.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.seven.jong.DTO.BoardDTO;
import com.seven.jong.DTO.BoardReplyDTO;

public interface IBoardMapper {
	//게시판 목록
	public List<BoardDTO> boardAllList(@Param("s")int start,@Param("e")int end);
	
	//게시판 수
	public int BoardCount();

	//게시글 저장
	public int writeSave(BoardDTO dto);
	
	//게시글 보기
	public BoardDTO contentView(int writeNo);
	
	//조회수
	public void upHit(int writeNo);

	//게시글 수정
	public void modify(BoardDTO dto);

	//게시글 삭제
	public void delete(int writeNo);

	//게시글 검색 목록
	public ArrayList<BoardDTO> boardSearchList(@Param("s")int start, @Param("e")int end, @Param("c")String c,@Param("search") String search);
	
	//검색 결과 수
	public int selectBoardCount(@Param("search")String search, @Param("c")String c);
	
	//리플 저장
	public void addReply(BoardReplyDTO rDto);
}
