package day7.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ13023_ABCDE {

	static int N, E;
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	static boolean result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from].add(to);
			adjList[to].add(from); // undirected graph
		}
		
//		for (int i = 0; i < N; i++) {
//			System.out.println(adjList[i]);
//		}
		
		for (int i = 0; i < N; i++) {
			visited = new boolean[N];
			visited[i] = true;
			DFS(i, 0);
			if (result) break;
		}
		if (result) System.out.println(1);
		else System.out.println(0);
	}

	private static void DFS(int currNode, int depth) {
		if (depth == 4) {
			result = true;
			return;
		}
//		System.out.println(currNode +" D:" + depth);
		for(int node : adjList[currNode]) {
			if (!visited[node]) {
				visited[node] = true;
				DFS(node, depth+1);
			}
		}
		visited[currNode] = false;
	}

}
