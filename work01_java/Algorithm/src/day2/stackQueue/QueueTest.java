package day2.stackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {
		// P1
		
		// 1-1
		Queue<Integer> que = new LinkedList<>();
		que.offer(100);
		que.offer(200);
		que.offer(300);
		que.offer(400);
		que.offer(500);
		System.out.println("큐: " + que.toString());
		
		// 1-2
		int front = que.poll();
		System.out.println("제거된 값: " + front);
		System.out.println("큐: " + que.toString());
		
		// 1-3
		System.out.println("맨 앞의 값: " + que.peek());
		
		// 1-4
		while(!que.isEmpty()) {
			que.poll();
//			System.out.println("제거된 값: " + que.poll());
			System.out.println("큐: " + que.toString());
		} 

	} // end main()

} // end class
