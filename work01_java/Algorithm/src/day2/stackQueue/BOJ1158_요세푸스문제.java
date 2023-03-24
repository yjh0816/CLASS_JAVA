package day2.stackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.listue;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1158_요세푸스문제 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 1 2 3 4 5 6 7
		// 1 2 4 5 6 7: 3
		// 1 2 4 5 7: 6
		// 1 4 5 7: 2
		// 1 4 5 : 7
		// 1 4 : 5
		// 4 : 1
		// : 4
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		LinkedList<Integer> list = new LinkedList<>();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= N; i++) {
			list.offer(i);
		}
//		System.out.println(list.toString());
		
		Iterator<Integer> iterator;
		int temp = 0;
		while(!list.isEmpty()) {
			iterator = list.iterator();
			for (int i = 0; i < K; i++) {
				if (iterator.hasNext())	{
					temp = iterator.next();
				} else if (!list.isEmpty()) {
					iterator = list.iterator();
					temp = iterator.next();
				} else {
					break;
				}
			}
			System.out.println(temp);
			list.remove(temp);
		}
		

		
	}

}
