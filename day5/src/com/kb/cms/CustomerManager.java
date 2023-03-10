package com.kb.cms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerManager implements ICustMgr {
	List<Customer> cs = new ArrayList<>();
//	1. 저장()
	@Override
	public void save(Customer c) {
		cs.add(c);
	}
//	2. 검색()
	@Override
	public void search() {
		for(Customer c: cs) {
			System.out.println(c);
		}
	}
	public void sortedSearch() {
//		Collections.sort(cs); // 이름으로 sort, Comparable 구현
		Collections.sort(cs, new MyComparator("주소"));
		for(Customer c: cs) {
			System.out.println(c);
		}
	}
//	3. 상세검색()
	@Override
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
	@Override
	public void update(int num, String address) {
		Customer result = search(num);
		if (result != null) {
			result.address = address;
		} else {
			System.out.println("Update Failed: Wrong customer number");
		}
	}
//	5. 삭제()
	@Override
	public void delete(int num) {
		Customer result = search(num);
		if (result != null) {
			cs.remove(result);
		} else {
			System.out.println("Delete Failed: Wrong customer number");
		}
	}
}
