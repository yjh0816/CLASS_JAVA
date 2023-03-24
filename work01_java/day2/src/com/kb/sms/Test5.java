package com.kb.sms;

import java.util.Random;

public class Test5 {

	public static void main(String[] args) {
		// case1
		Random r = new Random();
		int num = r.nextInt();
		System.out.println(num);
		
		// case2-if method is static, type is class_name.method_name()
		int a = Math.abs(-34);
		System.out.println(a);
		System.out.println(Math.random());
		
		String b = "123";
		int bb = Integer.parseInt(b);
		bb++;
		System.out.println(bb);
		
		
	}

}
