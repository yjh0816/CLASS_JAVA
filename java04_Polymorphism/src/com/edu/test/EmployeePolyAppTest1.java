package com.edu.test;
/*
 * Polymorphism
 * ::
 * Poly + Morphism
 * 여러가지 모양과 모습을 가지는 능력
 * 부모타입으로 여러가지 자식 클래스 객체 생성
 */
import com.edu.util.MyDate;
import com.edu.vo.Employee;
import com.edu.vo.Engineer;
import com.edu.vo.Manager;
import com.edu.vo.Secretary;

public class EmployeePolyAppTest1 {

	public static void main(String[] args) {
		Employee m = new Manager(111, "James", new MyDate(1997,9,17), 20000.0, "IT");
		Employee eg = new Engineer(222, "KIM", new MyDate(1964,5,21), 20000.0, "Django", 5000.0);
		Employee s = new Secretary(333, "PARK", new MyDate(1993,4,15), 20000.0, "James");
		/*
		 * Virtual Method Invocation 원리가 작동
		 * 1. 컴파일 시점의 메소드 -- Employee의 toString() 호출
		 * 2. 실행 시점의 메소드가 -- 실질적으로 생성된 자식 클래스의 toString() 호출
		 * 싱속관계로 이어진 클래스 사이에 Overriding 된 메소드에서 발생하는 원리
		 * 여기서 Virtual Method는 가상의 메소드로...자식의 메소드를 일컫는다.
		 */
		// Employee@의 toString() 호출...
		System.out.println(m.toString());
		
		System.out.println(eg);
		System.out.println(s);
		
		System.out.println("\n==========================================");
		
		// Manager의 부서를 Marketing 부서로 변경하기
		// changeDept() m 죽, Employee타입에서는 못찾는다.
		
//		Manager manager = (Manager)m;
//		manager.changeDept("Marketing");
		
		((Manager) m).changeDept("Marketing");
		System.out.println(m);
	
	} // end main()

} // end class

//Employee[] emps = {
//new Manager("James", new MyDate(1997,9,17), 20000.0, "IT"),
//new Engineer("KIM", new MyDate(1964,5,21), 20000.0, "Django", 5000.0),
//new Manager("Peter", new MyDate(1997,1,24), 45000.0, "IT"),
//new Secretary("PARK", new MyDate(1993,4,15), 20000.0, "James"),
//new Manager("Gosling", new MyDate(1997,2,24), 15000.0, "Marketing"),
//};
//
//System.out.println("===================Info===================");
//for (Employee e : emps) System.out.println(e.getDetails());
//
//System.out.println("\n===================Salary===================");
//for (Employee e : emps) {
//if(e instanceof Engineer) { //Employee타입으로 생성된 객체가 Engineer 라면
//System.out.println(e.getName()+"님의 연봉은 "+(e.getSalary()*12+((Engineer)e).getBonus())+"달러");	
//} else {
//System.out.println(e.getName()+"님의 연봉은 "+e.getSalary()*12+"달러");					
//}
//
//}
//
//System.out.println("\n===================Name===================");
//for (Employee e : emps) System.out.println("Employee 이름: "+e.getName());
