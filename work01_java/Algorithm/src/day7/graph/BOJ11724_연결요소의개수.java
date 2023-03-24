package day7.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ11724_연결요소의개수 {
	
	static int N, E;
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		E = sc.nextInt();
		adjList = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for (int i = 1; i <= E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjList[from].add(to);
			adjList[to].add(from);
		}
		
		int count = 0;
		for (int i = 1; i <= N; i++) {
			if(!visited[i]) {
				BFS(i); 
				count++;
			}
		}
		System.out.println(count);
		
		count = 0;
		visited = new boolean[N+1];
		visited[1] = true;
		for (int i = 1; i <= N; i++) {
			if(!visited[i]) {
				DFS(i);
				count++;
			}
		}
		System.out.println(count);
	}
	private static void DFS(int currNode) {
//		System.out.print(currNode);
		for(int node : adjList[currNode]) {
			if(!visited[node]) {
				visited[node] = true;
				DFS(node);
			}
		}
		
	}
	private static void BFS(int startNode) {
		Queue<Integer> queue = new LinkedList();
		queue.offer(startNode);
		visited[startNode] = true;
		while(!queue.isEmpty()) {
			int currNode = queue.poll();
//			System.out.print(currNode);
			for(int node : adjList[currNode]) {
				if(!visited[node]) {
					visited[node] = true;
					queue.offer(node);
				}
			}
		}
		
	}

}
