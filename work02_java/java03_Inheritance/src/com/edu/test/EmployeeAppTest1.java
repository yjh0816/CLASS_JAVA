package com.edu.test;

import com.edu.util.MyDate;
import com.edu.vo.Engineer;
import com.edu.vo.Manager;
import com.edu.vo.Secretary;

/*
 *  1. 객체 생성 == 클래스의 멤버를 메모리에 올린다.
 *  2. 접근
 *     1) 필드에 접근---> 값할당
 *     2) 메소드에 접근--> 호출
 */
public class EmployeeAppTest1 {

	public static void main(String[] args) {
//		Manager m = new Manager();
		
		/*
		 * 1. eg라는 이름으로 Engineer를 생성
		 * 2. s라는 이름으로 Secretary를 생성
		 * 3. Manager, Engineer, Secretary정보를 콘솔로 출력
		 * 4. Manager, Engineer, Secretary의 연봉을 출력
		 * 5. Manager, Engineer, Secretary의 이름을 각각 출력
		 */
		Manager m = new Manager("LEE", new MyDate(1997,9,17), 20000.0, "IT");
		Engineer eg = new Engineer("KIM", new MyDate(1964,5,21), 20000.0, "Django", 5000.0);
		Secretary s = new Secretary("PARK", new MyDate(1993,4,15), 20000.0, "LEE");
		
		System.out.println("===================Info===================");
		System.out.println(m.getDetails());
		System.out.println(eg.getDetails());
		System.out.println(s.getDetails());
		
		System.out.println("===================Salary===================");
		System.out.println("Manager 연봉: "+m.getSalary()*12+"달러");
		System.out.println("Engineer 연봉: "+eg.getSalary()*12+eg.getBonus()+"달러");
		System.out.println("Secretary 연봉: "+s.getSalary()*12+"달러");
		
		System.out.println("===================Name===================");
		System.out.println("Manager 이름: "+m.getName());
		System.out.println("Engineer 이름: "+eg.getName());
		System.out.println("Secretary 이름: "+s.getName());
//		System.out.println(m);
//		System.out.println(m2);
		
		//m.name = "Gosling";
//		m.setManagerField("Gosling",  new MyDate(2000,1,10), 30000.0, "Marketing");
//
//		System.out.println(m.getDetails());
//		System.out.println(m2.getDetails());

	}

}
