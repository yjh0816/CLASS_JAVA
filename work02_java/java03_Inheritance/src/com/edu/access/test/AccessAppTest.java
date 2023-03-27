package com.edu.access.test;

import com.edu.access.parent.Parent;

class Child extends Parent {
	public void test() {
		// publicVar는 서로 다른 클래스, 서로 다른 패키지라도 접근 허용
		System.out.println(publicVar);
		
		// protectedVar는 Child, Parent가 상속 관계.... public하고 동일한 효과
		System.out.println(protectedVar);
		
//		System.out.println(var);
	}
}

public class AccessAppTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
