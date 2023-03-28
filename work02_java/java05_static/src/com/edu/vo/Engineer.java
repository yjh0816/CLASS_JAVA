package com.edu.vo;

import com.edu.util.MyDate;

public class Engineer extends Employee {

	private String mainSkill;
	private double bonus;
	
	public Engineer() {
		super();
	}
	
	public Engineer(int empId, String name, MyDate birthday, double salary, String mainSkill, double bonus) {
		super(empId, name, birthday, salary);
		this.mainSkill = mainSkill;
		this.bonus = bonus;
	}

	public String getMainSkill() {
		return mainSkill;
	}

	public void changeMainSkill(String mainSkill) {
		this.mainSkill = mainSkill;
	}

	public double getBonus() {
		return bonus;
	}

	public void changeBonus(double bonus) {
		this.bonus = bonus;
	}
	
	@Override
	public String toString() {
		return super.toString()+","+mainSkill;
	}
	
}
