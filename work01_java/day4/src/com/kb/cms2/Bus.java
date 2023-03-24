package com.kb.cms2;

public class Bus extends Car {
	int seat;
	public Bus() {}
	public Bus(String num, int price, int seat) {
		this.num = num;
		this.price = price;
		this.seat = seat;
	}
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
	
}
