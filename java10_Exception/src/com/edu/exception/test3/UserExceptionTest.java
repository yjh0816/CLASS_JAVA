package com.edu.exception.test3;
/*
 사용자 정의 Exception
 1. 내가 직접 Exception	클래스를 만들어서 사용...
 2. 특정한 조건일때 내가 고의적으로 예외를 발생시키는 경우....
 "예외는 일종의 버그가 아니라
  강력한 제어문의 일종"
 */
class ZeroBoom extends Exception {
	ZeroBoom() {
		this("This is ZeroBoom Exception...");
	}
	ZeroBoom(String message) {
		super(message);
	}
	
}
class Acase {
	public void go() throws ZeroBoom { //go()를 호출하나 곳으로 날라간다.
		System.out.println("2. go()...calling...");
		int i = 10;
		int j = 0;
		
		if(j==0)
			throw new ZeroBoom("분모가 0이면 안되요~~!!");//폭탄을 터뜨린다!! ArithmeticException
	}
}
public class UserExceptionTest {

	public static void main(String[] args) {
		Acase a = new Acase();
		System.out.println("1. Acase Creating...");
		try {			
			a.go();
		} catch(ZeroBoom e) {
			System.out.println(e.getMessage());
		}

	}

}
