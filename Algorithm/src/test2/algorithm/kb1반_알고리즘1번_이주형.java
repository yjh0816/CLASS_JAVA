package test2.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class kb1반_알고리즘1번_이주형 {
	
	static int N, M;
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		adjList = new ArrayList[N+1];
		
		for (int i = 0; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from].add(to);
		}
		
		visited = new boolean[N+1];
		
		BFS(1);
		
		System.out.println(count);
		
	}

	private static void BFS(int startNode) {
		Queue<Integer> queue = new LinkedList();
		queue.offer(startNode);
		visited[startNode] = true;
		while(!queue.isEmpty()) {
			int currNode = queue.poll();
//			System.out.print(currNode);
			for(int node : adjList[currNode]) {
				if (!visited[node]) {
					count++;
					queue.offer(node);
					visited[node] = true;
				}
			}
		}
		
	}
}
