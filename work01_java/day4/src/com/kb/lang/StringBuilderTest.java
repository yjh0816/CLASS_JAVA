package com.kb.lang;

public class StringBuilderTest {

	public static void main(String[] args) {
		String s1 = new String("Hello");
		String s2 = "Hello";
		s2 = s1+s2; // 덧셈을 허용하지만, String 내부적으로 상수취급
		// 덧셈을 하게 되면 2개의 객체가 생성되고, 2개의 객체가 제거되는 작업 필요
		System.out.println(s2);
		
		// String : 편집이 많지않은 문자열
		// StringBuilder : 문자열 편집할때
		StringBuilder sb = new StringBuilder("ABC");
		System.out.println(sb); // sb.toString()
		sb.append("DEF"); // + 허용 안됨
		System.out.println(sb);
		System.out.println(sb.charAt(2));
		System.out.println(sb.length());
		sb.setLength(4);
		System.out.println(sb);
		System.out.println(sb.reverse());
		String result = sb.toString();
	}

}
