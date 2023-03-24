package com.edu.vo;

import com.edu.util.MyDate;

public class Manager extends Employee {
	
	private String dept;
	
	public Manager(String name, MyDate birthdate, double salary, String dept) {
		//무조건 부모 생성이 무조건 일어난다.
		super(name, birthdate, salary);
		this.dept = dept;
	}

	public String getDept() {
		return dept;
	}

	public void changeDept(String dept) {
		this.dept = dept;
	}
	
	@Override
	public String getDetails() {
		return super.getDetails()+","+dept;
	}
		
} // end class
