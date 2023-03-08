package com.kb.cms;

import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
	List<Customer> cs = new ArrayList<>();
//	1. 저장()
	public void save(Customer c) {
		cs.add(c);
	}
//	2. 검색()
	public void search() {
		for(Customer c: cs) {
			System.out.println(c);
		}
	}
//	3. 상세검색()
	public Customer search(int num) {
		Customer result = null;
		for(Customer c: cs) {
			if (c.num == num) {
				result = c;
				break;
			}
		}
		return result;
	}
//	4. 수정()
	public void update(int num, String address) {
		Customer result = search(num);
		if (result != null) {
			result.address = address;
		} else {
			System.out.println("Update Failed: Wrong customer number");
		}
	}
//	5. 삭제()
	public void delete(int num) {
		Customer result = search(num);
		if (result != null) {
			cs.remove(result);
		} else {
			System.out.println("Delete Failed: Wrong customer number");
		}
	}
}
