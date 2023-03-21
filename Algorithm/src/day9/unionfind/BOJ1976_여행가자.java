package day9.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1976_여행가자 {

	static int N, M;
	static int[] parents, journey;
	static boolean result = true;
	
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
	
	static boolean isSame(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		if (xRoot == yRoot) return true;
		else return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		make(N);
		
		int temp;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				temp = Integer.parseInt(st.nextToken());
				if (temp == 1) union(i,j);
			}
			
		}
//		System.out.println(Arrays.toString(parents));
		
		journey = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			journey[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i < M; i++) {
			if (isSame(journey[i-1], journey[i])) continue;
			else result = false;
		}
		
		if (result)	System.out.println("YES");
		else System.out.println("NO");
	}

}
