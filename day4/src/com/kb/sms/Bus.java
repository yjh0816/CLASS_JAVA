package com.kb.sms;

public class Bus extends Car implements Door {
	int seat;
	
	public void drive() {
		System.out.println("Drive 80km/h...");
	}
	public void autoDoor(boolean flag) {
		if(flag) {
			System.out.println("Door is opening..." + price);
		} else {
			System.out.println("Door is closing...");
		}
	}

	@Override
	public String toString() {
		return "Bus [seat=" + seat + ", num=" + num + ", price=" + price + "]";
	}
	@Override
	public void open() {
		System.out.println("Door is opening...");
		
	}
	@Override
	public void close() {
		System.out.println("Door is closing...");
		
	}
	
	
}
