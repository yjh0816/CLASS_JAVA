package test2.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class kb1반_알고리즘2번_이주형 {

	static int N, M;
	static int X, Y;
	static int day = 0, count = 0;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		visited = new boolean[M][N];
		
		for (int i = 0; i < M; i++) {
	    	String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
				if(map[i][j] == 1) count++;
			}
		}
				
		st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		
		BFS();
		System.out.println(day+2);
		System.out.println(count);

//		for (int i = 0; i < M; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
	}

	private static void BFS() {
		Queue<int[]> queue = new LinkedList();
		queue.offer(new int[] {Y-1, X-1});
		count--;
		visited[Y-1][X-1] = true;
		while(!queue.isEmpty()) {
			int[] currNode = queue.poll();
			int currY = currNode[0];
			int currX = currNode[1];
			
			for (int i = 0; i < 4; i++) {
				int nextY = dy[i]+currY;
				int nextX = dx[i]+currX;
				if (0 <= nextX && 0 <= nextY && nextX < N && nextY < M && map[nextY][nextX] == 1 && !visited[nextY][nextX]) {
					visited[nextY][nextX] = true;
					map[nextY][nextX] = map[currY][currX] + 1;
					day = map[nextY][nextX] > day ? map[nextY][nextX] : day;
					count--;
					queue.offer(new int[] {nextY, nextX});
				}
			}
		}
		
	}

}
