package com.edu.test;
/*
 * Polymorphism
 * Poly + Morphism
 * ::
 * 여러가지 모양과 모습을 가지는 능력
 * 부모타입으로 여러가지 자식 클래스 객체 생성
 * ::
 * 부모타입의 Container를 생성(배열)
 * 해당 Container 안에 자식 객체를 할당..
 * Heterogeneous Collection
 * 
 */
import com.edu.util.MyDate;
import com.edu.vo.Employee;
import com.edu.vo.Engineer;
import com.edu.vo.Manager;
import com.edu.vo.Secretary;

public class EmployeePolyAppTest2 {
	public static void main(String[] args) {	
		Employee[ ] emps=  {
			new Manager(111,"James", new MyDate(1990,3,24),200002.0,"IT"),
			new Engineer(222,"Gosling", new MyDate(1990,2,24),150.0,"python", 100),
			new Manager(333,"Peter", new MyDate(1990,1,24),450002.0,"IT"),
			new Secretary(444,"Juliet", new MyDate(1990,1,24),350002.0,"Gosling"),
			new Manager(555,"James1", new MyDate(1990,3,24),200002.0,"IT")				
		};
		
		System.out.println("========== 정보를 출력합니다.=================");			
		for(Employee e : emps) 
		System.out.println(e);
		
		
		System.out.println("\n========== 연봉 정보를 출력합니다.=================");
		
		for(Employee e : emps) {			
		if(e instanceof Engineer) {//Employee타입으로 생성된 객체가 Engineer 라면
		Engineer eg=(Engineer)e;
		System.out.println(e.getName()+" 님의 연봉은 "+(e.getSalary() * 12+eg.getBonus())+" 달러입니다.");
		}else {
		System.out.println(e.getName()+" 님의 연봉은 "+e.getSalary() * 12+" 달러입니다.");
		}			
		
		}
		
		System.out.println("\n========== 각 직원의 이름 정보를 출력합니다.=================");
		for(Employee e : emps) System.out.println("Employee Name :"+e.getName());	
		
	}
}



























