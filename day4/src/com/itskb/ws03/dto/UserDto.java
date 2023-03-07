package com.itskb.ws03.dto;

public class UserDto {
	public int userSeq;
	public String name;
	public String email;
	public String phone;
	boolean isSleep;
	public UserDto() {}
	public UserDto(int userSeq,	String name, String email, String phone, boolean isSleep) {
		this.userSeq = userSeq;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.isSleep = isSleep;
	}
	public String toString() {
		return "UserDto [userSeq=" + userSeq + ", name=" + name + ", email=" + email + ", phone=" + phone + ", isSleep="
				+ isSleep + "]";
	}
}
