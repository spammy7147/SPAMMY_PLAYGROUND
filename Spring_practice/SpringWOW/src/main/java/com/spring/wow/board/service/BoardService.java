package com.spring.wow.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.wow.board.model.BoardVO;
import com.spring.wow.board.repository.IBoardMapper;
import com.spring.wow.commons.SearchVO;

@Service
public class BoardService implements IBoardService {

	@Autowired
	private IBoardMapper mapper;
	
	@Override
	public void insert(BoardVO article) {
		mapper.insert(article);

	}



	@Override
	public void update(BoardVO article) {
		mapper.update(article);

	}

	@Override
	public void delete(Integer boardNo) {
		mapper.delete(boardNo);

	}



	@Override
	public List<BoardVO> getArticleList(SearchVO search) {
		List<BoardVO> list = mapper.getArticleList(search);
		
		for(BoardVO article : list) {
			//현재 시간 읽어오기
			long now = System.currentTimeMillis(); //밀리초로 읽기
			long regTime = article.getRegDate().getTime();
			
			if(now - regTime < 24*60*60*1000) {
				article.setNewMark(true);
			}
			
		}
		
		 return list;
	}



	@Override
	public Integer countArticles(SearchVO search) {
		return mapper.countArticles(search);
	}



	@Override
	public BoardVO getArticle(Integer boardNo) {
		mapper.updateViewCnt(boardNo);
		return mapper.getArticle(boardNo);
	}



}
