package com.edu.service;

import java.util.ArrayList;

import com.edu.exception.DuplicateIDException;
import com.edu.exception.RecordNotFoundException;
import com.edu.vo.Employee;

//기능의 Template을 모아놓은 인터페이스....
public interface EmployeeListService {
	void addEmployee(Employee e) throws DuplicateIDException;
	void deleteEmployee(String empId) throws RecordNotFoundException;
	void updateEmployee(Employee e);
	
	//Method Overloading 기법
	ArrayList<Employee> findEmployees(String addr);
	void findEmployees();
}
