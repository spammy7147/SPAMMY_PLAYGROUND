package com.spring.basic.ex04;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
//		Printer printer = new Printer(new Paper());
//		printer.showPaperInfo();
		
		GenericXmlApplicationContext ct
		= new GenericXmlApplicationContext("classpath:auto-config.xml");
		
		Printer printer = ct.getBean("printer", Printer.class);
		
		printer.showPaperInfo();
		
		ct.close();
		
	}

}
