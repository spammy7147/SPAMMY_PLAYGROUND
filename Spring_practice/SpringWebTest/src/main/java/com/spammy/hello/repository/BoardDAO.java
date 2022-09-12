package com.spammy.hello.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spammy.hello.model.BoardVO;

@Repository
public class BoardDAO implements IBoardDAO {

	//게시글을 저장할 리스트 : DB 대용
	private List<BoardVO> articles = new ArrayList<>();
	
	
	@Override
	public List<BoardVO> getArticles() {

		return articles;
	}

	@Override
	public void insertArticle(BoardVO article) {
		articles.add(article);

	}

	@Override
	public void deleteArticle(int idx) {
		articles.remove(idx);

	}

	@Override
	public BoardVO getContent(int idx) {
		return articles.get(idx);
	}

	@Override
	public void modifyArticle(BoardVO article, int idx) {
		articles.set(idx, article);

	}

}
