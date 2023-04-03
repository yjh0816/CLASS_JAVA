package com.jdbc.exception;
//찾을 수 없을 때
public class RecordNotFoundException extends Exception {
	public RecordNotFoundException() {
		this("This is RecordNotFoundException...");
	}
	
	public RecordNotFoundException(String message) {
		super(message);
	}
}
