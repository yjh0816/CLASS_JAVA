package com.kb.sms;

public class Test {

	public static void main(String[] args) {
		Car c = new Car();
		c.num = "서울나1234";
		c.price = 5000;
		c.drive();
//		c.drive(100);
		System.out.println(c);
		
		Bus b = new Bus();
		b.num = "서울나5678";
		b.price = 7000;
		b.seat = 45;
		b.drive();
		System.out.println(b);
	}

}
