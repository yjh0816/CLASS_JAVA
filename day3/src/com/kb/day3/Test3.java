package com.kb.day3;

public class Test3 {

	public static void main(String[] args) {
		MyDate mydate = new MyDate();
		System.out.println(mydate);
		MyDate mydate1 = new MyDate(2023, 3, 6);
//		mydate.year = 2023;
//		mydate.month = 3;
//		mydate.day = 6;
		System.out.println(mydate1); // mydate.toString()
		
		MyDate mydate2 = new MyDate(3, 23);
		System.out.println(mydate2);
	}

}
