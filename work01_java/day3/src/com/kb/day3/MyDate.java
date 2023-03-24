package com.kb.day3;

public class MyDate {
	int year;
	int month;
	int day;
	public MyDate() {}
	public MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	public MyDate(int month, int day) {
		this.year = 2023;
		this.month = month;
		this.day = day;
	}
	public String toString() {
		return year + "Year " + month + "Month " + day + "Day";
	}
}
