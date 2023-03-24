package com.edu.greet.test;

import com.edu.greet.Greeting;

public class GreetingAppTest {

	public static void main(String[] args) {
		/*
		 * 1. 클래스 객체를 생성 == 클래스의 멤버를 메모리에 올린다.
		 * 2. 접근
		 *    1) 필드접근----> 값할당
		 *    2) 메소드접근---> 호출
		 */
		//1
		Greeting g = new Greeting();

		//2
		g.target = "1반 여러분~~";
		g.message = "반갑습니다~~!!";
		
		System.out.println(g.sayHello());
	}

}
