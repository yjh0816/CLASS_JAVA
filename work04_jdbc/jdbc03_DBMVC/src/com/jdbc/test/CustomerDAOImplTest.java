package com.jdbc.test;

import java.util.ArrayList;

import com.jdbc.dao.CustomerDAOImpl;
import com.jdbc.domain.Customer;

public class CustomerDAOImplTest {

	public static void main(String[] args) {
		CustomerDAOImpl dao = CustomerDAOImpl.getInstance();
		try {
//			dao.registerCustomer(new Customer("111","James","Boston"));
//			dao.registerCustomer(new Customer("333","James","Boston"));
//			dao.removeCustomer("333");
//			dao.updateCustomer(new Customer("333","제임스","보스톤"));
			System.out.println(dao.getCustomer("333"));
			
//			ArrayList<Customer> customer = dao.getCustomer();
//			for(Customer c : customer) {
//				System.out.println(c);
//			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
