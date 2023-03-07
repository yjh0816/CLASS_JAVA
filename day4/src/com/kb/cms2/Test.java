package com.kb.cms2;

public class Test {

	public static void main(String[] args) {
		CarManager mgr = new CarManager();
		mgr.save(new Bus("1111", 5000, 45));
		mgr.save(new Bus("2222", 7000, 35));
		mgr.save(new Bus("3333", 8000, 45));
		mgr.search();
//		System.out.println(mgr.search("2222"));
		
	}

}
