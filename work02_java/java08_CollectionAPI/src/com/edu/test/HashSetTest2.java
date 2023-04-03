package com.edu.test;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest2 {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("F");
		set.add("A");
		set.add("B");
		set.add("A");
		set.add("C");
		set.add("A");
		
		System.out.println(set);
		System.out.println(set.size());//3
		boolean flag = set.remove("B");
		System.out.println("삭제가 진행되었나요? "+flag);
		System.out.println(set);
		
		set.clear();
		System.out.println(set);
	}

}
