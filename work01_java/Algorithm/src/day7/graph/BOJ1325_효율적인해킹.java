package day7.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1325_효율적인해킹 {
	
	static int N, E;
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	static int t_count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st;
	    st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    E = Integer.parseInt(st.nextToken());
	    
		adjList = new ArrayList[N+1];
		int[] count = new int[N];
		
		
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
	        int from = Integer.parseInt(st.nextToken());
	        int to = Integer.parseInt(st.nextToken());
			adjList[to].add(from);
		}
		
		int max = 0;
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N+1];
			t_count = 0;
			if (!visited[i]) {
				visited[i] = true;
				count[i-1] = DFS(i);
			}
			max = count[i-1] > max ? count[i-1] : max;
		}
		
//		System.out.println(Arrays.toString(count));
		for (int i = 1; i <= N; i++) {
			if (count[i-1] == max) System.out.print(i + " ");
		}

	}
	private static int DFS(int currNode) {
//		System.out.print(currNode);
		t_count++;
		for(int node : adjList[currNode]) {
			if (!visited[node]) {
				visited[node] = true;
				DFS(node);
			}
		}
		return t_count;
	}

}
