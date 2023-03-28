package com.edu.service.impl;

import java.util.ArrayList;

import com.edu.service.EmployeeListService;
import com.edu.vo.Employee;
import com.edu.vo.Engineer;
import com.edu.vo.Manager;

public class EmployeeListServiceImpl implements EmployeeListService {
	//필드 추가
	private ArrayList<Employee> list;
	
	//싱글톤
	private static EmployeeListServiceImpl service  = new EmployeeListServiceImpl();
	private EmployeeListServiceImpl() {
		list = new ArrayList<>();
	}
	public static EmployeeListServiceImpl getInstance() {
		return service;
	}
	
	@Override
	public void addEmployee(Employee e) {
		//추가하고자 하는 직원이 존재한다면...추가안함/ 없을때 추가
		boolean find = false;
		for(Employee emp : list) {
			if(emp.getEmpId().equals(e.getEmpId())) { //추가하고자 하는 직원이 존재한다면...
				find = true;
				System.out.println(e.getName()+"님은 이미 직원으로 등록되어 있습니다.");
				return; //원래 호출한 지점으로 코드를 다시 되돌려놓는다
			}//if
		}//for
		
		if(find==false) { //추가하려는 직원이 없다면
			list.add(e);
			System.out.println(e.getName()+"님이 직원으로 등록되었습니다.");
		}
	}

	@Override
	public void deleteEmployee(String empId) {
		boolean find = false;
		for(Employee emp : list) {
			if(emp.getEmpId().equals(empId)) {
				find = true;
				System.out.println(emp.getName()+"님이 탈퇴처리 되었습니다.");
				list.remove(emp);
				break;
			}//if
		}//for
		if(find==false) {
			System.out.println("삭제대상 직원을 찾을 수 없습니다.");
		}
		
	}

	@Override
	public void updateEmployee(Employee e) {
		boolean find= false;
        for(Employee emp : list) {
            if(emp.getEmpId().equals(e.getEmpId())) { //수정할 대상이 존재한다면
               find = true;
               emp.setName(e.getName());
               emp.setAddr(e.getAddr());
               emp.setSalary(e.getSalary());
               if(emp instanceof Manager) {
                   ((Manager) emp).changeDept(((Manager) e).getDept());
               }else {
                   ((Engineer) emp).changeTech(((Engineer) e).getTech());
                   ((Engineer) emp).changeBonus(((Engineer) e).getBonus());
               }
            }//if
        }//for
        if(find==false)System.out.println("수정할 직원정보가 존재하지 않습니다.");        
		
	}

	@Override
	public ArrayList<Employee> findEmployees(String addr) {
		ArrayList<Employee> temp = new ArrayList<>();
		for(Employee emp : list) {
			if(emp.getAddr().equals(addr)) {
				temp.add(emp);
			}
		}
		return temp;
	}

	@Override
	public void findEmployees() {
		for(Employee emp : list) {
			System.out.println(emp);
		}
		
	}

}
