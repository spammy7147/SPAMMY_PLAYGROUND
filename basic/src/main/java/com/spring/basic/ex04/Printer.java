package com.spring.basic.ex04;

import org.springframework.beans.factory.annotation.Autowired;

public class Printer {

	private Paper paper;
	
	@Autowired
	public Printer(Paper paper) {
		this.paper = paper;
	}
	
	
	public void showPaperInfo() {
		
		for (String info : paper.data) {
			System.out.println(info);
		}
		
	}
	
}
