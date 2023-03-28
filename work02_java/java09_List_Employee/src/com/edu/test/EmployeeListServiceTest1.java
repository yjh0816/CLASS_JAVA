package com.edu.test;

import java.util.ArrayList;

import com.edu.exception.DuplicateIDException;
import com.edu.exception.RecordNotFoundException;
import com.edu.service.impl.EmployeeListServiceImpl;
import com.edu.vo.Employee;
import com.edu.vo.Engineer;
import com.edu.vo.Manager;

public class EmployeeListServiceTest1 {

	public static void main(String[] args) {
		//1. Service 생성된 객체를 하나 받아온다..
		EmployeeListServiceImpl service = EmployeeListServiceImpl.getInstance();				
				
		//2. method를 각각 호출..
		System.out.println("======================== 1. add ================================== ");
		Manager m1 = new Manager("111", "강호동", "대림", 500, "개발부");
		Manager m2 =new Manager("222", "이수근","여의도",400,"오락부");
		Manager m3 =new Manager("333", "서장훈", "대림", 600, "개발부");
		
		Engineer eg1 = new Engineer("444", "김희철", "서초동", 450,"Python",100);
		Engineer eg2 =new Engineer("555", "이상민", "가산", 500, "JS",300);
		
		System.out.println("\n========================Employee CRUD==================================\n");
		System.out.println("\n======================== 1. insert ================================== ");
		try {
			service.addEmployee(m1);
			service.addEmployee(m2);				
			
			service.addEmployee(m3);
			service.addEmployee(eg1);
			service.addEmployee(eg2);
			service.addEmployee(m3);			
		} catch (DuplicateIDException e) {
			System.out.println(e.getMessage());
		}
		
//		
		service.findEmployees();
				
		System.out.println("\n======================== 2. delete ================================== ");
		try {
			service.deleteEmployee("333");			
		} catch (RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}
		service.findEmployees();
		
		System.out.println("\n======================== 3. update ================================== ");
		service.updateEmployee(new Manager("111", "강호동", "구로", 500, "개발부2") );
		service.findEmployees();
		
		System.out.println("\n======================== 4. findEmployees ================================== ");
		ArrayList<Employee> returnList=service.findEmployees("대림");
		for(Employee emp : returnList)System.out.println(emp);
//	
//		System.out.println("========================");

	}
}






















