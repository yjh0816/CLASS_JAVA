package com.self.service;

import com.self.vo.Employee;
import com.self.vo.Engineer;
import com.self.vo.Manager;

public class EmployeeService {
	Employee[] emps;
	int idx = 0;
	
	private static EmployeeService service  = new EmployeeService(10);
	private EmployeeService(int size){
		emps = new Employee[size];
	}
	public static EmployeeService getInstance() {
		return service;
	}
	public void addEmployee(Employee e) {	
		emps[idx++] = e;
	}

	public void deleteEmployee(String name) {
		for(int i=0; i<idx; i++) {
			if(emps[i].getName().equals(name)) {
				for(int j=i; j<idx; j++) {
					emps[j] = emps[j+1];
				}
				emps[idx] = null;
				idx--;
			}
		}
	}

	public void updateEmployee(double salary,String name) {	
		for(Employee employee : emps) {	
			if(employee==null) continue;
			if(employee.getName().equals(name)) {
				employee.setSalary(salary);		
			}			
		}
	}
	public void updateEmployee(String dept,int deptno, String name) {	
		for(Employee employee : emps) {	
			if(employee==null) continue;
			if(employee instanceof Manager) {
				if(employee.getName().equals(name)) {
					((Manager) employee).setDept(dept);	
					((Manager) employee).setDeptno(deptno);				
				}	
			}
		}
	}
	public void updateEmployee(String tech,double bonus, String name) {	
		for(Employee employee : emps) {	
			if(employee==null) continue;
			if(employee instanceof Engineer) {
				if(employee.getName().equals(name)) {
					((Engineer) employee).setTech(tech);	
					((Engineer) employee).setBonus(bonus);				
				}	
			}
		}
	}

	//Method Overloading
	/*
	 * 하는일은 똑같은데...처리하는 데이타를 달리할때 쓰는 기법
	 * 메소드의 통일감을 강조하면서도 서로다른 데이타를 처리할수 있게끔 해준다.
	 */
	public Employee findEmployee(String name) {
		Employee e = null;
		for(Employee employee : emps) {
			if(employee==null) continue;			
			if(employee.getName().equals(name))
				e = employee;
		}
		return e;
	}
	public Employee[ ] findEmployee(int deptno) {
		Employee[ ] temp = new Employee[emps.length];
		int count = 0;
		for(Employee employee : emps) {
			if(employee==null) continue;
			if(employee instanceof Manager) {
				if(((Manager) employee).getDeptno()==deptno) {
					temp[count++] = employee;
				}
			}
		}
		return temp;
	}

	//추가
	public void printAllEmployee() {		
		for(Employee e : emps) {
			if(e!=null)
			System.out.println(e);
		}
	}
	public void printEmployees(String job) {		
		for(Employee e : emps) {
			if(e!=null)
			if(job.equals("m")) {
				if(e instanceof Manager) {
					System.out.println(e);
				}
			}
			if(job.equals("e")) {
				if(e instanceof Engineer) {
					System.out.println(e);
				}
			}
		}
	}
	public int getAnnualSalary(Employee e) {
		int annualSalary = 0;
		annualSalary = (int)(e.getSalary() * 12);
		if (e instanceof Engineer) {
			annualSalary = (int)(e.getSalary() * 12 + ((Engineer) e).getBonus());
		}
		return annualSalary;
	}
	

	public int getTotalCost() {
		int totalCost = 0;
		for(Employee e : emps) {
			if(e==null) continue;
			totalCost += getAnnualSalary(e);
		}
		return totalCost;
	}
}

