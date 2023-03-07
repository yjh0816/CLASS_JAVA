package com.kb.cms2;

import java.util.ArrayList;
import java.util.List;

// 차량관리 클래스
// 차량들을 CRUD
public class CarManager {
	List<Car> cars = new ArrayList<>();
	// 저장
	public void save(Car c) {
		cars.add(c);
	}
	
	// 검색
	public void search() {
		/*
		for(int i=0; i<cars.size(); i++) {
			System.out.println(cars.get(i));
		}
		*/
		for(Car c: cars) {
			System.out.println(c);
		}
	}
	public Car search(String num) {
		//overloading
		for(Car c: cars) {
			if (c.num.equals(num)) {
				return c;
			}
		}
		return null;
	}
	
	// 수정
	public void update(String num) {
		
	}
	
	// 삭제
	public void delete(String num) {
		Car c = search(num);
		if (c != null)	cars.remove(c);
//		for(Car c: cars) {
//			if (c.num.equals(num)) {
//				cars.remove(c);
//			}
//		}
	}
}
