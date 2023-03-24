package day9.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1717_집합의표현 {
	
	static int N, M;
	static int[] parents;
	
	static void make(int n) {
		parents = new int[n+1];
		for (int i = 0; i <= n; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int x) {
		if (parents[x] == x) return x;
		return parents[x] = find(parents[x]);
	}
	
	static void union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		if (xRoot == yRoot) return;
		parents[yRoot] = parents[xRoot];
	}
	
	static String isSame(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		if (xRoot == yRoot) return "YES";
		else return "NO";
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		make(N);
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int opr = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (opr == 0) union(a, b);
			else if (opr == 1) System.out.println(isSame(a,b));	
		}
		

	}

}
