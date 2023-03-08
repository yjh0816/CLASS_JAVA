package com.kb.cms;

public class Test {

	public static void main(String[] args) {
		ICustMgr cm = new CustomerManager();
		cm.save(new Customer(1001, "LEE", "Seoul"));
		cm.save(new Customer(1002, "PARK", "Inchon"));
		cm.save(new Customer(1003, "CHOI", "Seoul"));
		cm.save(new VipCustomer(2001, "KIM", "Daegu", "11가1234"));
		cm.save(new VipCustomer(2002, "LEE", "Busan", "swim","22나5678"));
		System.out.println("===== getUserList =====");
		cm.search();
		System.out.println("===== getUserDetail =====");
		System.out.println(cm.search(1001));
		System.out.println("===== updateUserAddress:Busan =====");
		cm.update(1001, "Busan");
		System.out.println(cm.search(1001));
		System.out.println("===== deleteUser =====");
		cm.delete(1001);
		cm.search();
	}

}
