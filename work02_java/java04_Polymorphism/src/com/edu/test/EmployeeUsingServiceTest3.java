package com.edu.test;
import com.edu.service.EmployeeService;
/*
 
            Employee   -----------------------> EmployeeService ----->EmployeeUsingServiceTest           
               |
 Manager    Engineer   Engineer
 
 
 
 */
import com.edu.util.MyDate;
import com.edu.vo.Employee;
import com.edu.vo.Engineer;
import com.edu.vo.Manager;
import com.edu.vo.Secretary;

public class EmployeeUsingServiceTest3 {
	public static void main(String[] args) {	
		Employee[ ] emps=  {
			new Manager(111,"James", new MyDate(1990,3,24),200002.0,"IT"),
			new Engineer(222,"Gosling", new MyDate(1990,2,24),150.0,"python", 100),
			new Manager(333,"Peter", new MyDate(1990,1,24),450002.0,"IT"),
			new Secretary(444,"Juliet", new MyDate(1990,1,24),350002.0,"Gosling"),
			new Manager(555,"James1", new MyDate(1990,3,24),200002.0,"IT")				
		};
		
		// Service 객체 생성
		EmployeeService service = new EmployeeService();
		
		// Service 객체의 기능을 호출...리턴된 데이터를 받아서 출력		
		System.out.println("========== 1. 직원 정보를 출력합니다.=================");			
		service.printAllEmployee(emps);
		
		System.out.println("\n========== 2. 특정 직원을 검색합니다.=================");		
		Employee e1 = service.findEmployee(emps, 333);
		System.out.println(e1);
		
		System.out.println("\n=========== 3. 동일한 부서에서 근무하는 직원을 검색합니다.=================");		
		Employee[] temp1 = service.findEmployee(emps, "IT");
		for(Employee e : temp1) {
			if(e==null) continue; //중간에 null이 있는 경우 사용
			// 만약 마지막이 null로 채워져있다면 break 사용 추천
			System.out.println(e);
		}
		
		System.out.println("\n========== 4. 특정 직원의 연봉을 받아옵니다.=================");
		System.out.println(service.getAnnualSalary(emps[3])+" 만원");
				
		System.out.println("\n========== 5. 총 인건비 정보입니다.=================");
		System.out.println(service.getTotalCost(emps)+" 만원");
		
	}
}



























