package com.spring.database.test;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class DBConnectTest {
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@125.132.133.80:1521:XE";
	private String uid = "spammy";
	private String upw = "1";
	
	
	//DB연결 테스트
	@Test
	public void connetionTest() {
		
		Connection conn = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			System.out.println("DB 커넥션 성공!");
			System.out.println("conn : " + conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {conn.close();
			}catch (Exception e){
			}
			}
		
	}
}
