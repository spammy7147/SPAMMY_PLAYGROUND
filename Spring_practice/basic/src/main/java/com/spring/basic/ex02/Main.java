package com.spring.basic.ex02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		
//		DataBaseInfo dbInfo = new DataBaseInfo();
//		dbInfo.setUid("Spring");
//		dbInfo.setUpw("sss111");
//		dbInfo.setUrl("jdb:oracle:");

		GenericXmlApplicationContext ct = new GenericXmlApplicationContext("classpath:db-config.xml");
		DataBaseInfo db1 = ct.getBean("db1",DataBaseInfo.class);
		System.out.println("URL: " + db1.getUrl());
		System.out.println("UID: " + db1.getUid());
		System.out.println("UPW: " + db1.getUpw());
	
		System.out.println("==============================");
		
		DataBaseInfo db2 = ct.getBean("db2",DataBaseInfo.class);
		System.out.println("URL: " + db2.getUrl());
		System.out.println("UID: " + db2.getUid());
		System.out.println("UPW: " + db2.getUpw());
			
		System.out.println("==============================");
		
		MemberDAO dao = ct.getBean("dao",MemberDAO.class);
		//dao.setDbInfo(db2);
		dao.showDBInfo();
		
	}
}
