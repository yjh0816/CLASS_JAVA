package com.jdbc.test;

import com.jdbc.dao.CustomerDAO;

import config.ServerInfo;

/*
 * 1. CustomerDAO객체생성(==메모리에 올린다)
 * 2. CustomerDAO의 기능을 호출
 */
public class CustomerDAOTest {

	public static void main(String[] args) throws Exception {

		CustomerDAO dao = new CustomerDAO();
//		dao.addCustomer("333", "전도연1", "서초동1");
//		dao.removeCustomer("333");
//		dao.updateCustomer("222", "전도연", "방배동");
		dao.printAllCustomer();

	}//main
	
	static {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("Driver Loading....");
		}catch(ClassNotFoundException e) {
			System.out.println("Driver Loading....Fail..");
		}
	}
}//class
