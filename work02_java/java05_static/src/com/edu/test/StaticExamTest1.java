package com.edu.test;
/*
 * static한 멤버는 객체생성 없이 사용가능
 * 로컬 레벨에서 사용 안됨
 */
class StaticExam {
	static String name1 = "홍길동";
	String name2 = "문동은";
	
	public void getMember() {
		System.out.println("우/유/빛/깔 " + name1);
		System.out.println("우/유/빛/깔 " + name2);
	}
	
	public static void getMember2() { //static...이미 메모리 올라가 있다
		System.out.println("우/유/빛/깔 " + name1); //이미 메모리 올라가 있다
		//System.out.println("우/유/빛/깔 " + name2); //메모리 없다. 객체 생성해야 올라간다
	}
}
public class StaticExamTest1 {
	public static void main(String[] args) {
		StaticExam.getMember2(); //객체생성 과정 없이 바로 사용.호출
//		StaticExam.getMember(); // 반드시 객체생성한 후(메모리 올린후) 멤버 호출
		
		StaticExam s = new StaticExam();
		s.getMember();
	}

}
