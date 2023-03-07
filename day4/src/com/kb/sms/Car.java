package com.kb.sms;

public class Car {
	String num;
	int price;

	// Overloading
	public void drive() {
		System.out.println("Drive 60km/h...");
	}
	
	public void drive(int speed) {
		System.out.printf("Drive %dkm/h...\n",speed);
	}

	public String toString() {
		return "Car [num=" + num + ", price=" + price + "]";
	}
	
}
