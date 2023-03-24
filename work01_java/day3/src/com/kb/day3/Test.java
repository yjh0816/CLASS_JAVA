package com.kb.day3;

public class Test {
	public static void main(String[] args) {
		MyDate mydate = new MyDate();
		mydate.year = 2023;
		mydate.month = 3;
		mydate.day = 6;
		String s = mydate.toString();
		System.out.println(s);
		System.out.println(mydate.toString());
		System.out.println(mydate); // not address, instead toString
	}
}
