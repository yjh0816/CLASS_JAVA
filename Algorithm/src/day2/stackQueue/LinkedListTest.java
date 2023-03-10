package day2.stackQueue;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListTest {

	public static void main(String[] args) {
		int N = 10000;
		long start, end;
		ArrayList<Integer> arr = new ArrayList<>();
		LinkedList<Integer> list = new LinkedList<>();
		System.out.println("LinkedList");
		start = System.currentTimeMillis();
		// 리스트 값 삽입
		for (int i = 0; i < N; i++) {
			list.add(0, i); // 0번 인덱스에 i값 삽입
		}
		end = System.currentTimeMillis();
		System.out.println("반복문 실행 시간: " + (end-start));

		System.out.println("ArrayList");
		start = System.currentTimeMillis();
		// 배열 값 삽입
		for (int i = 0; i < N; i++) {
			arr.add(0, i); // 0번 인덱스에 i값 삽입
//			arr.add(i); // 맨뒤에 값을 추가하기에 0(1)로 감소
		}
		end = System.currentTimeMillis();
		System.out.println("반복문 실행 시간: " + (end-start));
	}

}
