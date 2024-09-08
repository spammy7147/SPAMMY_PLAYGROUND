package com.spring.basic.ex01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
//		Hotel hotel = new Hotel(new Restaurant(new Chef()));
//		hotel.reserveRestaurant();

		
		GenericXmlApplicationContext ct = new GenericXmlApplicationContext("classpath:test-config.xml");
		
		
		Hotel hotel = ct.getBean("hotel", Hotel.class);
		hotel.reserveRestaurant();
		
	}

}
