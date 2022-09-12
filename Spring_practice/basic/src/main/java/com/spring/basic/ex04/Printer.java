package com.spring.basic.ex04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;



/*
	@Autowired 
	- 객체를 자동 주입할 떄 사용하는 아노테이션
	- 스캔명령을 통해 객체를 찾아 주입하는데 타입이름으로 검색
	- 타입을 찾아내지 못하면 (id 속성값) 을 통해 검색합니다
	- 생성자, 필드, 메서드에 적용가능
	- 필드에 자동주입 설정을 수행할 때는 기본 생성자가 반드시 있어야함

	@Qualifier("bean id")
	- Autowired 를 사용할떄 동일 타입의 빈이 여러개 있을경우 
	어떤 빈을 주입해야 하는지 선택해주는 추가 아노테이션

*/

public class Printer {

	
	@Autowired
	@Qualifier("paper2")
	private Paper paper;
	
	public Printer() {
		
	}
	
	
//	public Printer(Paper paper) {
//		this.paper = paper;
//	}
//	
	
	
	public void showPaperInfo() {
		
		for (String info : paper.data) {
			System.out.println(info);
		}
		
	}
	
}
