package day7.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AdjList {
	
	static ArrayList<Integer>[] adjList;
	static int N, E;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		N = Integer.parseInt(br.readLine());
//		E = Integer.parseInt(br.readLine());
		N = sc.nextInt();
      E = sc.nextInt();
		adjList = new ArrayList[N];
		visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			adjList[i] = new ArrayList();
		}
		
		for (int i = 0; i < E; i++) {
//			st = new StringTokenizer(br.readLine());
//			int from = Integer.parseInt(st.nextToken());
//			int to = Integer.parseInt(st.nextToken());
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjList[from].add(to);
//			adjList[to].add(from); // undirected graph
		}
		for (int i = 0; i < N; i++) {
			System.out.println(adjList[i]);
		}
		BFS(0);
		
		System.out.println();
		visited = new boolean[N];
		visited[0] = true;
		DFS(0);
	}

	private static void DFS(int currNode) {
		System.out.print(currNode);
		for(int node : adjList[currNode]) {
			if (!visited[node]) {
				visited[node] = true;
				DFS(node);
			}				
		}
	}

	private static void BFS(int startNode) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(startNode);
		visited[startNode] = true;
		
		while(!queue.isEmpty()) {
			int currNode = queue.poll();
			System.out.print(currNode);
			for(int node : adjList[currNode]) {
				if (!visited[node]) {
					queue.offer(node);
					visited[node] = true;
				}				
			}
		}
		
	}

}
/*
7
8
0 1
0 2
1 3
1 4
3 5
4 5
5 6
2 6
 */