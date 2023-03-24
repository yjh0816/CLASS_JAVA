package com.edu.vo;

import com.edu.util.MyDate;

public class Secretary extends Employee {

	private String bossOfName;

	public Secretary() {}
	
	public Secretary(String name, MyDate birthdate, double salary, String bossOfName) {
		super(name, birthdate, salary);
		this.bossOfName = bossOfName;
	}

	public String getBossOfName() {
		return bossOfName;
	}

	public void changeBossOfName(String bossOfName) {
		this.bossOfName = bossOfName;
	}
	
	@Override
	public String getDetails() {
		return super.getDetails()+","+bossOfName;
	}
}
