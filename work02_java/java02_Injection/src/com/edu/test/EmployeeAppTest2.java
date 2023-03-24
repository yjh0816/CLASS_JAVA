package com.edu.test;

import com.edu.util.MyDate;
import com.edu.vo.Engineer;
import com.edu.vo.Manager;
import com.edu.vo.Secretary;
/*
 * Manager타입의 배열을 생성
 * 이 안에 여러명의 Manager객체를 넣고
 * 한번에 핸들링할 수 있는 코드를 작성
 */
public class EmployeeAppTest2 {

	public static void main(String[] args) {
		Manager[] managers = {
				new Manager("James", new MyDate(1997,9,17), 20000.0, "IT"),
				new Manager("Gosling", new MyDate(1997,2,24), 15000.0, "Marketing"),
				new Manager("Peter", new MyDate(1997,1,24), 45000.0, "IT")
		};

		System.out.println("===================Info===================");
		for (Manager m : managers) System.out.println(m.getDetails());

		System.out.println("===================Salary===================");
		for (Manager m : managers) System.out.println(m.getSalary()*12+"달러");
		
		System.out.println("===================Name===================");
		for (Manager m : managers) System.out.println("Manager 이름: "+m.getName());

	}

}
