package kr.co.wow.user.model;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserDAO implements IUserDAO {
	
	
	private static UserDAO dao = new UserDAO();
	
	
	private UserDAO() {
		try {
			InitialContext ct = new InitialContext();
			DataSource ds = (DataSource) ct.lookup("java:comp/env/jdbc/gaja");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static UserDAO getInstance() {
		
		if (dao == null ) {
			dao = new UserDAO();
		}
		
		return dao;
	}
	

	
	///////////////////////////////////////////////////

	@Override
	public void userAdd(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void userDel(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void userChange(UserVO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void userSearch(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void userPwChange(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public int userCheck(String id, String pw) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean confirmId(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
