package com.spring.wow.board.repository;

import java.util.List;

import com.spring.wow.board.model.BoardVO;
import com.spring.wow.commons.PageVO;

//게시판 관련 CRUD 추상 메서드 선언
public interface IBoardMapper {

	//게시글 등록 기능
	void insert(BoardVO article);
	
	//게시글 목록 조회
	List<BoardVO> getArticleList();
	
	//게시글 상세 조회기능
	BoardVO getArticle(Integer boardNo);
	
	//게시글 수정
	void update(BoardVO article);

	//게시글 삭제
	void delete(Integer boardNo);
	 
	//게시글 페이징 목록 조회
	List<BoardVO> getArticleListPaging(PageVO page);
	
	//총 게시물의 수 조회기능
	Integer countArticles();
	
}
