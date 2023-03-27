package com.edu.vo;

import com.edu.util.MyDate;

public class Secretary extends Employee {

	private String bossOfName;

	public Secretary() {}
	
	public Secretary(int empId, String name, MyDate birthdate, double salary, String bossOfName) {
		super(empId, name, birthdate, salary);
		this.bossOfName = bossOfName;
	}

	public String getBossOfName() {
		return bossOfName;
	}

	public void changeBossOfName(String bossOfName) {
		this.bossOfName = bossOfName;
	}
	
	@Override
	public String toString() {
		return super.toString()+","+bossOfName;
	}
}
