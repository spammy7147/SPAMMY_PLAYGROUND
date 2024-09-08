package com.spring.wow.board.service;

import java.util.List;

import com.spring.wow.board.model.BoardVO;
import com.spring.wow.commons.PageVO;
import com.spring.wow.commons.SearchVO;

public interface IBoardService {


	//게시글 등록 기능
	void insert(BoardVO article);

	//게시글 목록 조회
	//List<BoardVO> getArticleList();

	//# 검색, 페이징 기능이 보함된 게시물 목록 조회기능
	List<BoardVO> getArticleList(SearchVO search);

	//검색 or 페이징에 따른 게시물의 수 조회
	Integer countArticles(SearchVO search);

	//게시글 상세 조회기능
	BoardVO getArticle(Integer boardNo);



	//게시글 수정
	void update(BoardVO article);

	//게시글 삭제
	void delete(Integer boardNo);

	//	//게시글 페이징 목록 조회
	//	List<BoardVO> getArticleListPaging(PageVO page);
	//
	//	//총 게시물의 수 조회기능
	//	Integer countArticles();
	//	
	//	//제목으로 검색기능
	//	List<BoardVO> getArticleListByTitle(SearchVO search);
	//	
	//	//제목으로 검색 이후 게시물 수 조회기능
	//	Integer countArticlesByTitle(SearchVO search);
	//	
	//	//작성자 검색기능
	//	List<BoardVO> getArticleListByWriter(SearchVO search);
	//		
	//	//작성자 검색 이후 게시물 수 조회기능
	//	Integer countArticlesByWriter(SearchVO search);
	//	
	//	//내용 검색기능
	//	List<BoardVO> getArticleListByContent(SearchVO search);
	//		
	//	//내용 검색 이후 게시물 수 조회기능
	//	Integer countArticlesByContent(SearchVO search);
	//	
	//	//내용 + 제목 검색기능
	//	List<BoardVO> getArticleListByTitleOrContent(SearchVO search);
	//		
	//	//내용 + 제목 검색 이후 게시물 수 조회기능
	//	Integer countArticlesByTitleOrContent(SearchVO search);

}
