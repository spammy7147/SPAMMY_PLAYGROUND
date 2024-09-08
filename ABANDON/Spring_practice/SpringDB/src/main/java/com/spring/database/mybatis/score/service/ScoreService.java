package com.spring.database.mybatis.score.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.database.mybatis.score.model.ScoreVO;
import com.spring.database.mybatis.score.repository.IScoreMapper;

@Service("scoreService2")
public class ScoreService implements IScoreService {
	
	@Autowired
	private IScoreMapper dao;
	
	@Override
	public void insertScore(ScoreVO score) {
		score.calData();
		dao.insertScore(score);

	}

	@Override
	public List<ScoreVO> selectAllScores() {
		return dao.selectAllScores();
	}

	@Override
	public void deleteScore(int stuNum) {
		dao.deleteScore(stuNum);

	}
	
	@Override
	public ScoreVO selectOne(int stuNum) {
		
		return dao.selectOne(stuNum-1);
	}
	
	

}
