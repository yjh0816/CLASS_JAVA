package com.kb.lang;

public class MathTest {

	public static void main(String[] args) {
		int su1 = -37;
		System.out.println(Math.abs(su1));
		double su2 = 34.5678;
		System.out.println(Math.round(su2*100)/100.);
		
		String s = "123";
		int si = Integer.parseInt(s);
		si += 3;
		System.out.println(si);
	}

}
