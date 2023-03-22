package day10.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge {
	
	int from, to, weight;
	
	public Edge(int from, int to, int weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
}

public class BOJ1197_최소스패닝트리 {
	
	static int V, E;
	static Edge[] edgeList;
	static int[] parents;
	
	static void make() {
		parents = new int[V+1];
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int x) {
		if (parents[x] == x) return x;
		return parents[x] = find(parents[x]);
	}
	
	static boolean union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		if (xRoot == yRoot) return false;
//		parents[yRoot] = parents[xRoot];
		parents[yRoot] = xRoot;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		edgeList = new Edge[E];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(from, to, weight);
		}
		
		Arrays.sort(edgeList, (e1, e2) -> e1.weight - e2.weight);
		
		make();
		
		int edgeCount = 0;
		int totalWeight = 0;
		for (Edge e : edgeList) {
			if (union(e.from, e.to)) {
				edgeCount++;
				totalWeight += e.weight;
				if (edgeCount == V-1) break;
			}
		}

		System.out.println(totalWeight);
	} // end main()
} // end class
/*
3 3
1 2 1
2 3 2
1 3 3
*/
/*
5 7
1 4 1
1 2 2
2 3 3
1 3 4
3 4 5
4 5 6
2 5 7
*/
