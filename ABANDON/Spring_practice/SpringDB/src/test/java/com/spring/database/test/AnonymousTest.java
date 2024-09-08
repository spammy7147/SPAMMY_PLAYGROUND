package com.spring.database.test;

public class AnonymousTest {

	public static void main(String[] args) {

		Car s = new Sonata();
		s.run();

		Car ferrari = new Car() {
			@Override
			public void run() {
				System.out.println("페라리 달림");
			}
		};
		
		ferrari.run();
		
		new Car() {
			@Override
			public void run() {
				System.out.println("말리부가 팍팍달립니다");
				
			}
		}.run();
		
		//lambda 식 적용: 인터페이스 안에 추상메서드가 단 하나일경우만 가능!!
		Car tucson = () -> {System.out.println("투싼이 달립니다");};
		tucson.run();
		
		///////////////////////////////////////////
		
		//계산기 인터페이스와 람다식
		Calculator sharp = new Calculator() {
			
			@Override
			public int add(int n1, int n2) {
				System.out.println("샤프 계산기의 덧셈!");
				return n1+n2;
			}
		};
		
		System.out.println("===================");
		System.out.println(sharp.add(10, 15));
		
		
		Calculator casio = (x,y) ->{
			System.out.println("카시오 계산기의 덧셈!");
			return x+y;
		};
		
		System.out.println(casio.add(100, 200));
		
		
		Calculator shaomi = (x,y)-> x+y;
		System.out.println("샤오미 결과 :" + shaomi.add(30, 50));
		
		
	}

}
