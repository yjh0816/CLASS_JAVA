package com.self.test;

import com.self.service.EmployeeService;
import com.self.util.MyDate;
import com.self.vo.Employee;
import com.self.vo.Engineer;
import com.self.vo.Manager;

public class EmployeeServiceTest {
	public static void main(String[] args) {
		//1. Service 객체를 생성

		EmployeeService service  = EmployeeService.getInstance();
		
		//2. method를 각각 호출..
		System.out.println("============ 1. addManager ============ ");
		service.addEmployee(new Manager("AAA", new MyDate(1978, 1, 1), 20000.0, "개발부", 10));
		service.addEmployee(new Manager("BBB", new MyDate(1975, 2, 1), 34000.0, "기획부", 20));
		service.addEmployee(new Manager("CCC", new MyDate(1980, 3, 3), 20000.0, "교육부", 30));
		service.addEmployee(new Manager("DDD", new MyDate(1995, 8, 1), 37000.0, "개발부", 10));
		
		System.out.println("============ Manager 정보확인 ============ ");
		service.printEmployees("m");
		
		System.out.println("\n============ 1. addEngineer ============ ");
		service.addEmployee(new Engineer("EEE", new MyDate(1995,3,4), 350000.0, "Java", 200.0));
		service.addEmployee(new Engineer("FFF", new MyDate(1995,7,2), 350000.0, "Java", 200.0));
		service.addEmployee(new Engineer("GGG", new MyDate(1994,11,2), 450000.0, "Python", 300.0));
		
		System.out.println("============ Engineer 정보확인 ============ ");
		service.printEmployees("e");
		
		System.out.println("\n============ 2. deleteManager(AAA 삭제) ============ ");
		service.deleteEmployee("AAA");
		System.out.println("============ Manager 정보확인 ============ ");
		service.printEmployees("m");
		
		System.out.println("\n============ 3. updateManager(CCC 연봉 수정 200->350) ============ ");
		service.updateEmployee(35000.0, "CCC");//?
		System.out.println("============ Manager 정보확인 ============ ");
		service.printEmployees("m");
		
		System.out.println("\n============ 4. findManager(BBB) ============ ");
		Employee retM1= service.findEmployee("BBB");
		System.out.println(retM1.toString());
		
		System.out.println("\n============ 4. findManager(10) ============ ");
		System.out.println("10번 부서에 근무하는 직원들 입니다..");
		Employee[ ] retMs1 = (Employee[]) service.findEmployee(10);
		for(Employee m : retMs1) {
			if(m==null) continue;
			System.out.println(m.toString());
		}
		
		System.out.println("\n============ 5. 특정 직원의 연봉을 받아옵니다.=================");
		Employee retE1= service.findEmployee("EEE");
		System.out.println(service.getAnnualSalary(retE1)+" 만원");
				
		System.out.println("\n============ 6. 총 인건비 정보입니다.=================");
		System.out.println(service.getTotalCost()+" 만원");
	}
}







