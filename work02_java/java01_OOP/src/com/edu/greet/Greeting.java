package com.edu.greet;
/*
 *  특정한 대상에게
 *  다양한 인삿말을 출력하는 정보를 가지는 클래스
 *  
 *  OOP.....Object
 */
public class Greeting {
	// 필드...클래스 바로 밑에 선언...메소드 블락 바깥에 선언
	public String target;
	public String message;
	
	// 기능을 정의
	public String sayHello() {
		return target + " , " + message + "~~~!!";
	}
}
