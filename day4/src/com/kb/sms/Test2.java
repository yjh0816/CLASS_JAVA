package com.kb.sms;

public class Test2 {

	public static void main(String[] args) {
//		Car c = new Car();
//		c.drive();
		
		Car b = new Bus(); // object's polymorphism
		b.drive(); // method's polymorphism
		System.out.println(b);
		
		Door d = new Bus();
		d.open();
		d.close();

	}

}
