package com.edu.exception;

//수정, 삭제할 대상이 없을때 발생하는 사용자예외 클래스
public class RecordNotFoundException extends Exception {
	public RecordNotFoundException() {
		this("This is RecordNotFoundException...");
	}
	public RecordNotFoundException(String message) {
		super(message);
	}
}
