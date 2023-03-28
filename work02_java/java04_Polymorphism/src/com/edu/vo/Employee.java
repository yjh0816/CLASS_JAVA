package com.edu.vo;

import com.edu.util.MyDate;
//부모 클래스, Super class, Parent Class
public class Employee {
	private int empId;
	private String name;
	private MyDate birthdate;
	private double salary;
	
	// 상수값
	public static final double BASIC_SALARY = 100;
	
	public Employee(int empId, String name, MyDate birthdate, double salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.birthdate = birthdate;
		this.salary = salary;
	}
	/*
	 * this
	 * 1)local V와 field의 이름이 동일할때 구분하기 위해서 필드 앞에 붙인다
	 * 2)this()-->하나의 클래스에서 또 다른 생성자를 호출할때 사용함
	 */
	public Employee(int empId, String name, MyDate birthdate) {
		this(empId, name, birthdate, BASIC_SALARY);
	}
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public int getEmpId() {
		return empId;
	}
	
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MyDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(MyDate birthdate) {
		this.birthdate = birthdate;
	}

	public double getSalary() {
		return salary;
	}

	public void changeSalary(double salary) {
		this.salary = salary;
	}
	
//	public String getDetails() {
//		return name+","+birthdate.getDate()+","+salary;
//	}
	@Override
	public String toString() {
		return empId+","+name+","+birthdate+","+salary;
	}
	
	
}
