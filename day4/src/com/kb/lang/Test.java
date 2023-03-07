package com.kb.lang;

public class Test {

	public static void main(String[] args) {
		int i = 0; // stack은 초기화 x
		i += 3;
		
		int[] su = new int[3]; // new는 무조건 heap
		System.out.println(su[1]); // heap은 무조건 초기화 o
		
		String s1 = new String("ABC");
		String s2 = new String("ABC");
		String s3 = "ABC";
		String s4 = "ABC";
		
		System.out.println(s1 == s2); // false
		System.out.println(s1.equals(s2)); // true
		System.out.println(s3 == s4); // true
		System.out.println(s3.equals(s4)); // true
		
//		System.out.println(s1 == s3);
//		System.out.println(s1.equals(s3));
	}

}
