package com.kb.sms;

public class Test {

	public static void main(String[] args) {
		// case 1
		Student s = new Student();
		s.num = 1001;
		s.name = "LEE";
		s.study();
		s.work(1);
		
		Student s2 = new Student();
		s2.num = 1002;
		s2.name = "KIM";
		s2.study();
		s2.work(5);
//		Student.study();

	}

}
