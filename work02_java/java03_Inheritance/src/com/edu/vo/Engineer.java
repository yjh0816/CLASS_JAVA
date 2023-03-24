package com.edu.vo;

import com.edu.util.MyDate;

public class Engineer extends Employee {

	private String mainSkill;
	private double bonus;
	
	public Engineer() {
		super();
	}
	
	public Engineer(String name, MyDate birthday, double salary, String mainSkill, double bonus) {
		super(name, birthday, salary);
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
	public String getDetails() {
		return super.getDetails()+","+mainSkill+","+bonus;
	}
	
}
