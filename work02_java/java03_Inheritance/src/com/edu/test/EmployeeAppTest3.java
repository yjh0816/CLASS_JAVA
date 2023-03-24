package com.edu.test;

import com.edu.util.MyDate;
import com.edu.vo.Employee;
import com.edu.vo.Engineer;
import com.edu.vo.Manager;
import com.edu.vo.Secretary;
/*
 * Employee타입의 배열을 생성
 * 이 안에 여러명의 Manager,Engineer,Secretary객체를 넣고
 * 부모타입으로 단일하게 이기종간의 객체들을 핸들링할 수 있는 코드를 작성
 * ::
 * Heterogeneous Collection(상속덕분) 
 */
public class EmployeeAppTest3 {

	public static void main(String[] args) {
		Employee[] emps = {
				new Manager("James", new MyDate(1997,9,17), 20000.0, "IT"),
				new Engineer("KIM", new MyDate(1964,5,21), 20000.0, "Django", 5000.0),
				new Manager("Peter", new MyDate(1997,1,24), 45000.0, "IT"),
				new Secretary("PARK", new MyDate(1993,4,15), 20000.0, "James"),
				new Manager("Gosling", new MyDate(1997,2,24), 15000.0, "Marketing"),
		};

		System.out.println("===================Info===================");
		for (Employee e : emps) System.out.println(e.getDetails());

		System.out.println("\n===================Salary===================");
		for (Employee e : emps) {
			if(e instanceof Engineer) { //Employee타입으로 생성된 객체가 Engineer 라면
				System.out.println(e.getName()+"님의 연봉은 "+(e.getSalary()*12+((Engineer)e).getBonus())+"달러");	
			} else {
				System.out.println(e.getName()+"님의 연봉은 "+e.getSalary()*12+"달러");					
			}

		}
		
		System.out.println("\n===================Name===================");
		for (Employee e : emps) System.out.println("Employee 이름: "+e.getName());

	}

}
