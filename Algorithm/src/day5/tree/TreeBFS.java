package day5.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeBFS {

	static char[] nodes;
	static int SIZE, lastIndex;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SIZE = sc.nextInt();
		lastIndex = SIZE;
		nodes = new char[SIZE+1];
		
		for (int i = 0; i < SIZE; i++) {
			nodes[i+1] = (char)('A' + i);
		}
		
		System.out.println(Arrays.toString(nodes));
		BFS();
	}
	private static void BFS() {
		Queue<Integer> que = new LinkedList<>();
		
		// 시작 노드 En-queue : 루트 노드
		que.offer(1);
		
		while(!que.isEmpty()) {
			// De-queue (방문)
			int currIndex = que.poll();
			System.out.print(nodes[currIndex]);
			// En-queue
			if (currIndex*2 <= lastIndex) que.offer(currIndex*2);
			if (currIndex*2+1 <= lastIndex) que.offer(currIndex*2+1);
		}
		
	}
}
