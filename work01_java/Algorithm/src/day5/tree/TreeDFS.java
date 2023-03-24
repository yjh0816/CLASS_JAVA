package day5.tree;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class TreeDFS {

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
//		DFS(1);
		System.out.println();
		DFSByPreOrder(1);
		System.out.println();
		DFSByInOrder(1);
		System.out.println();
		DFSByPostOrder(1);
	}
	private static void DFS(int currIndex) {
//		if (currIndex <= lastIndex) { // 기저 조건
//			return;
//		}
		System.out.print(nodes[currIndex]); // 노드 방문
		if (currIndex*2 <= lastIndex) DFS(currIndex*2); // 왼쪽 자식 노드 방문
		if (currIndex*2+1 <= lastIndex) DFS(currIndex*2+1); // 오른쪽 자식 노드 방문
		
	}
	// 전위 순회
	private static void DFSByPreOrder(int currIndex) {
		System.out.print(nodes[currIndex]); // 노드 방문
		if (currIndex*2 <= lastIndex) DFSByPreOrder(currIndex*2); // 왼쪽 자식 노드 방문
		if (currIndex*2+1 <= lastIndex) DFSByPreOrder(currIndex*2+1); // 오른쪽 자식 노드 방문
	}
	// 중위 순회
	private static void DFSByInOrder(int currIndex) {
		if (currIndex*2 <= lastIndex) DFSByInOrder(currIndex*2); // 왼쪽 자식 노드 방문
		System.out.print(nodes[currIndex]); // 노드 방문
		if (currIndex*2+1 <= lastIndex) DFSByInOrder(currIndex*2+1); // 오른쪽 자식 노드 방문
	}
	// 후위 순회
	private static void DFSByPostOrder(int currIndex) {
		if (currIndex*2 <= lastIndex) DFSByPostOrder(currIndex*2); // 왼쪽 자식 노드 방문
		if (currIndex*2+1 <= lastIndex) DFSByPostOrder(currIndex*2+1); // 오른쪽 자식 노드 방문
		System.out.print(nodes[currIndex]); // 노드 방문
	}
}

