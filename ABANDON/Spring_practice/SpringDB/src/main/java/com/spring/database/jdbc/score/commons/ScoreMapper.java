package com.spring.database.jdbc.score.commons;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.database.jdbc.score.model.ScoreVO;

//jdbc Template 에서 resultset을 편하게 사용하기 위한 클래스 생성
public class ScoreMapper implements RowMapper<ScoreVO>{

	@Override
	public ScoreVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ScoreVO score =  new ScoreVO();
		
		score.setStuId(rs.getInt("stu_id"));
		score.setStuName(rs.getString("stu_name"));
		score.setKor(rs.getInt("kor"));
		score.setEng(rs.getInt("eng"));
		score.setMath(rs.getInt("math"));
		score.setTotal(rs.getInt("total"));
		score.setAverage(rs.getDouble("average"));
		return score;
	}
}
