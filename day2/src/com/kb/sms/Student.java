package com.kb.sms;

public class Student {
	int num;
	String name;
	
	static void study() {
		System.out.println("Studying...");
	}
	void work(int time) {
//		if (time==0) return;
		System.out.println("Working " + time + " times...");
//		work(--time);
	}
}
