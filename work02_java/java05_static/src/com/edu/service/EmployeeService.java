package com.edu.service;

import com.edu.vo.Employee;
import com.edu.vo.Engineer;
import com.edu.vo.Manager;

// 싱글톤 패턴으로 작성
public class EmployeeService {
	// 1. 
	private static EmployeeService service = new EmployeeService();
	
	// 2.
	private EmployeeService() {
		System.out.println("EmployeeService creating...ONLY ONE!");
	}
	
	// 3.
	public static EmployeeService getInstance() {
		return service;
	}
	
	// 1. 모든 직원의 정보를 출력하는 기능을 정의...method 선언부만 일단 작성..구현부는 함께
	// All, ~s, ~All~s
	public void printAllEmployee(Employee[] ea) {
		for(Employee e : ea) {
			System.out.println(e);
		}
	}
	
	// 2. 모든 직원중 특정한 직원을 검색하는 기능을 정의
	// find~~, search~~
	public Employee findEmployee(Employee[] ea, int empId) {
		Employee employee = null;
		for(Employee e : ea) {
			if(e.getEmpId() == empId) {
				employee = e;
				break;	// empId는 unique한 값
			}
		}
		return employee;
	}
	
	// 3. 모든 직원중 동일한 부서에서 근무하는 직원을 리턴
	public Employee[] findEmployee(Employee[] ea, String dept) {
		Employee[] temp = new Employee[ea.length];
		int idx = 0;
		for(Employee e : ea) {
			if (e instanceof Manager) {
				if(((Manager) e).getDept().equals(dept)) {
					temp[idx++] = e;
				}
			}
		}
		return temp;
	}
	
	// 4. 특정한 직원의 연봉을 리턴하는 기능을 정의
	public int getAnnualSalary(Employee e) {
		int annualSalary = 0;
		annualSalary = (int)(e.getSalary() * 12);
		if (e instanceof Engineer) {
			annualSalary = (int)(e.getSalary() * 12 + ((Engineer) e).getBonus());
		}
		return annualSalary;
	}
	
	// 5. 모든 직원의 연간 총 인건비를 리턴하는 기능을 정의
	public int getTotalCost(Employee[] ea) {
		int totalCost = 0;
		for(Employee e : ea) {
			totalCost += getAnnualSalary(e);
		}
		return totalCost;
	}
}
