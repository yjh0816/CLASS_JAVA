package com.kb.cms;

public class VipCustomer extends Customer {
	String hobby;
	String carNumber;
	public VipCustomer() {
		super();
	}
	public VipCustomer(int num, String name, String address, String hobby, String carNumber) {
		super(num, name, address);
		this.hobby = hobby;
		this.carNumber = carNumber;
	}
	public VipCustomer(int num, String name, String address, String carNumber) {
		this(num, name, address, "", carNumber);
	}
	@Override // Compiler에게 Overriding 문법이 맞는지 체크 요청
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VipCustomer [");
		builder.append(super.toString());
		builder.append(", hobby=");
		builder.append(hobby);
		builder.append(", carNumber=");
		builder.append(carNumber);
		builder.append("]");
		return builder.toString();
	}
	
}
