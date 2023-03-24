package com.kb.arr;

public class Test1 {

	public static void main(String[] args) {
		// array 
		// 1. declare
		int[] s;
		int a[];
		// 2. construct
		s = new int[5];
		int[] b = new int[5];
		// 3. initialize
		s[0] = 11;
		s[1] = 22;
		int[] c = {11,22,33,44,55}; // declare + construct + initialize
		int[] d = new int[] {11,22,33,44,55}; // declare + construct + initialize
		m(c);
//		m({11,22,33,44,55}); // error
		m(d);
		m(new int[] {11,22,33,44,55});
		// 4. search
		System.out.println(s[1]);
		System.out.println(c[0]);
		for(int cc: c) {
			System.out.println(cc + " ");
		}
	}
	public static void m(int[] s) {
//		System.out.println(s.length);
	}

}
