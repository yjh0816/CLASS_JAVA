package day2.stackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ2164_카드2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Deque<Integer> deq = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			deq.offer(i+1);
		}

		int result = 0;
		while(!deq.isEmpty()) {
			result = deq.poll();
			if (!deq.isEmpty()) deq.offer(deq.poll());
		}
		System.out.println(result);
	}

}
