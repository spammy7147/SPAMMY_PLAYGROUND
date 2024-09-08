package com.spring.basic.ex03;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ct = new GenericXmlApplicationContext("classpath:prototype-config.xml");
		
		Person kim = ct.getBean("person",Person.class);
		Person cho = ct.getBean("person", Person.class);
		
		System.out.println(kim);
		System.out.println(cho);
		System.out.println(kim == cho);
		//자동으로 싱글톤 형식으로 가지고온다
		
		System.out.println("================================");
		
		cho.setName("조철왕");
		cho.setAge(30);
		
		System.out.println("kim의 이름: "  + kim.getName());
		System.out.println("kim의 이름: "  + kim.getAge());
		
		
		System.out.println("cho의 이름: "  + cho.getName());
		System.out.println("cho의 이름: "  + cho.getAge());
		
	}

}
