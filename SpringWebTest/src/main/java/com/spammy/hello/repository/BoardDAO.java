package com.spammy.hello.repository;

import java.util.ArrayList;
import java.util.List;

import com.spammy.hello.model.BoardVO;

public class BoardDAO implements IBoardDAO {

	//게시글을 저장할 리스트 : DB 대용
	private List<BoardVO> articles = new ArrayList<>();
	
	
	@Override
	public List<BoardVO> getArticles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertArticle(BoardVO article) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteArticle(int idx) {
		// TODO Auto-generated method stub

	}

	@Override
	public BoardVO getContent(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyArticle(BoardVO article, int idx) {
		// TODO Auto-generated method stub

	}

}
