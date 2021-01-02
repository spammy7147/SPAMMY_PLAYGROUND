package kr.co.wow;

public class UserVO {
	
//	CREATE TABLE wow_user(
//		    id VARCHAR2(20) PRIMARY KEY,
//		    pw VARCHAR2(20) NOT NULL,
//		    name VARCHAR2(20) NOT NULL,
//		    email VARCHAR2(50)
//		  );
	
	private String id;
	private String pw;
	private String name;
	private String email;
	
	
	public UserVO() {}
	
	
	
	
	
	public UserVO(String id, String pw, String name, String email) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getPw() {
		return pw;
	}



	public void setPw(String pw) {
		this.pw = pw;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
