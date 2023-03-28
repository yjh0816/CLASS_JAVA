package com.edu.exception;

//empId가 존재하는 경우 발생하는 사용자예외 클래스
public class DuplicateIDException extends Exception {
	public DuplicateIDException() {
		this("This is DuplicateIDException...");
	}
	public DuplicateIDException(String message) {
		super(message);
	}
}
