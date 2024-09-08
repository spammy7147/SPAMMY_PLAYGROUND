package kr.co.wow.board.model;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BoardDAO implements IBoardDAO {
	
	
	
	
	private DataSource ds;
	private static BoardDAO dao = new BoardDAO();
	
	private BoardDAO() {
		InitialContext ct;
		try {
			ct = new InitialContext();
			ds = (DataSource) ct.lookup("java:comp/env/jdbc/gaja");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	private static BoardDAO getInstance() {
		if (dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	}
	
	
	
	/////////////////////////////////////////////////////////

	@Override
	public void boardAdd(String writer, String title, String content) {
		// TODO Auto-generated method stub

	}

	@Override
	public void boardDel(int bId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void boardFix(int bId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<BoardVO> boardList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardVO boardContent(int bId) {
		// TODO Auto-generated method stub
		return null;
	}

}
