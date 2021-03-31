package com.spring.database.jdbc.score.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.database.jdbc.score.commons.ScoreMapper;
import com.spring.database.jdbc.score.model.ScoreVO;


@Repository
public class ScoreDAO implements IScoreDAO {
	
	//jdbc Template 에서 resultset을 편하게 사용하기 위한 클래스 생성
	class ScoreMapper implements RowMapper<ScoreVO>{
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

	//spring jdbc 
	@Autowired
	private JdbcTemplate template;
	
	@Override
	public void insertScore(ScoreVO score) {
		String sql = "INSERT INTO scores VALUES(stu_id.Nextval,?,?,?,?,?,?)";
		template.update(sql,
				score.getStuName()
				,score.getKor()
				,score.getEng()
				,score.getMath()
				,score.getTotal()
				,score.getAverage()
				);

	}

	@Override
	public List<ScoreVO> selectAllScores() {
		String sql = "SELECT * FROM scores";
		
		return template.query(sql, (rs,rowNum) ->{
			ScoreVO score =  new ScoreVO();
			score.setStuId(rs.getInt("stu_id"));
			score.setStuName(rs.getString("stu_name"));
			score.setKor(rs.getInt("kor"));
			score.setEng(rs.getInt("eng"));
			score.setMath(rs.getInt("math"));
			score.setTotal(rs.getInt("total"));
			score.setAverage(rs.getDouble("average"));
			return score;
		}); 
	}

	@Override
	public void deleteScore(int stuNum) {
		String sql = "DELETE FROM scores WHERE stu_id=?";
		System.out.println("DAO 삭제 : stu_id = " + stuNum);
		template.update(sql,stuNum);

	}
	
	//queryForObject 는 single row를 리털할 떄 사용합니다.
	//query 는 multi row를 리턴할 떄 사용합니다.
	
	@Override
	public ScoreVO selectOne(int stuNum) {
		String sql = "SELECT * FROM scores WHERE stu_id=?";
		template.queryForObject(sql,new ScoreMapper(),stuNum);
		return null;
		
	}

}
