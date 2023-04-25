package spring.service.dice.impl;

import java.util.Random;

import spring.service.dice.Dice;

public class DiceCImpl implements Dice{
	///Field
	private int value;

	///Constructor
	public DiceCImpl() {
		System.out.println("::"+getClass().getName()+" 생성자....");
	}
	
	public DiceCImpl(int value) {
		System.out.println("::"+getClass().getName()+" 생성자....");
		this.value = value;
	}


	//Method (getter/setter)
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	//==> 주사위를 던저 선택되는 숫자를 생산하는 행위(무작위로 숫자 생산)
	public void selectedNumber(){
		value = new Random().nextInt(6) + 1;
	}
	
}//end of class