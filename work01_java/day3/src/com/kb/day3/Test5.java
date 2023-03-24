package com.kb.day3;

public class Test5 {

	public static void main(String[] args) {
		int[] su = new int[5];
//		for(int s:su) {
//			System.out.print(s);
//		}
		// 00000
		su[1] = 30;
		
		MyDate[] mydate = new MyDate[5];
//		for(MyDate md : mydate) {
//			System.out.print(md);
//		}
		// nullnullnullnullnull
		mydate[0] = new MyDate(3,23);
		mydate[1] = new MyDate(4,21);
		mydate[2] = new MyDate(5,5);
		mydate[3] = new MyDate(5,15);
		mydate[4] = new MyDate(5,29);
		
		MyDate m = mydate[2];
		System.out.println(m);
		System.out.println(mydate[1]);
		
		// Print all
		for(MyDate md : mydate) {
			System.out.println(md);
		}
		for(int i=0; i<mydate.length; i++) {
			System.out.println(mydate[i]);
		}
		
		// Print only May
		for(MyDate md : mydate) {
			if (md.month == 5) {
				System.out.println(md);	
			}
		}
		
	}

}
