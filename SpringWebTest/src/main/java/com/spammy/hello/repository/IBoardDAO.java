package com.spammy.hello.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spammy.hello.model.BoardVO;


public interface IBoardDAO {

	
	
	//게시글 목록 가져오기
	List<BoardVO> getArticles();
	
	//게시글 등록 기능
	void insertArticle(BoardVO article);
	
	//게시글 삭제
	void deleteArticle(int idx);
	
	//게시글 내용보기
	BoardVO getContent(int idx);
	
	//게시글 수정
	void modifyArticle(BoardVO article, int idx);
}
