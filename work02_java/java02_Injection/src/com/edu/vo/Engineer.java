package com.edu.vo;

import com.edu.util.MyDate;

/*
 * 1. private 필드 선언
 * 2. 값이 주입되는 통로
 *    public 명시적 생성자
 *    public setter
 * 3. public 주입된 값을 반환하는 기능을 정의
 * 
 * name, birthday, salarym, mainSkill, bonus --> 5
 */
public class Engineer {
	private String name;
	private MyDate birthday;
	private double salary;
	private String mainSkill;
	private double bonus;
	
	public Engineer() {}
	
	public Engineer(String name, MyDate birthday, double salary, String mainSkill, double bonus) {
		this.name = name;
		this.birthday = birthday;
		this.salary = salary;
		this.mainSkill = mainSkill;
		this.bonus = bonus;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MyDate getBirthday() {
		return birthday;
	}

	public void setBirthday(MyDate birthday) {
		this.birthday = birthday;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getMainSkill() {
		return mainSkill;
	}

	public void setMainSkill(String mainSkill) {
		this.mainSkill = mainSkill;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public String getDetails() {
		return name + "," + birthday.getDate() + "," + salary + "," + mainSkill + "," + bonus;
	}
}
