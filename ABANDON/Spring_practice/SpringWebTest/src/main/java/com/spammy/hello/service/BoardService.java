package com.spammy.hello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spammy.hello.model.BoardVO;
import com.spammy.hello.repository.BoardDAO;

@Service("board")
public class BoardService implements IBoardService {
	
	@Autowired
	BoardDAO dao;
	
	@Override
	public List<BoardVO> getArticles() {
		
		return dao.getArticles();
	}

	@Override
	public void insertArticle(BoardVO article) {
		dao.insertArticle(article);

	}

	@Override
	public void deleteArticle(int boardNo) {
		dao.deleteArticle(boardNo-1);

	}

	@Override
	public BoardVO getContent(int boardNo) {
		
		return dao.getContent(boardNo-1);
	}

	@Override
	public void modifyArticle(BoardVO article, int boardNo) {
		dao.modifyArticle(article, boardNo-1);

	}

}
