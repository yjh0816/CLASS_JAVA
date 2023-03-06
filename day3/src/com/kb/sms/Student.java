package com.kb.sms;
import java.lang.*;
import java.util.*;

public class Student {
	int num;
	String name;
	Scanner s;
	public Student() {}
	public Student(int num, String name ) {
		this.num = num;
		this.name = name;
	}
	static void study() {
		System.out.println("Studying...");
	}
	void work(int time) {
		System.out.println("Working " + time + " times...");
	}
}
