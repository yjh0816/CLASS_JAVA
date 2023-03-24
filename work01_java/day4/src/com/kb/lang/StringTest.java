package com.kb.lang;

public class StringTest {

	public static void main(String[] args) {
		String s = new String("IT's your life");
		String s1 = new String("ABC ");
		String s2 = "      ABC "; // String만 허용
		String s3 = s2 + s; // String만 + 허용
		String s4 = "ABE";
		System.out.println(s3);
		System.out.println(s3.length()); // 길이
		System.out.println(s3.toLowerCase()); // 소문자
		System.out.println(s3);
		System.out.println(s1==s2); // 같으냐?
//		System.out.println(s1.getClass().getName());
//		System.out.println(s2.getClass().getName());
		System.out.println(s1.equals(s2)); // 참조하고 있는 값이 같으냐?
		System.out.println(s2.compareTo(s4)); // s2 - s4 = -2(negative)
		// A=65, B=66, C=67, D=68, E=69
		System.out.println(s.indexOf('\''));
		System.out.println(s.indexOf("your"));
		System.out.println(s.substring(5,9));
//		System.out.println(s.charAt(3));
		System.out.println(s2 + 10 + 30); // toString
		System.out.println(10 + 30 + s2); // addNum toString
		char ch = 'A';
		System.out.println(ch+1); //66 
		// char vs int -> to big type
		System.out.println(++ch); //B
		
		System.out.println(s2.trim());
	}

}
