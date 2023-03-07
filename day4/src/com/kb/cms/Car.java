package com.kb.cms;

public abstract class Car {
	String num;
	int price;

	// Overloading
	public abstract void drive();
	
	public void drive(int speed) {
		System.out.printf("Drive %dkm/h...\n",speed);
	}

	public String toString() {
		return "Car [num=" + num + ", price=" + price + "]";
	}
	
}
