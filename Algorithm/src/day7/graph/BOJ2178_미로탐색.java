package day7.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178_미로탐색 {
	
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());

	    map = new int[N][M];
	    visited = new boolean[N][M];
	    
	    for (int i = 0; i < N; i++) {
	    	String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
	    
	    for (int i = 0; i < N; i++) {
	    	System.out.println(Arrays.toString(map[i]));
	    }

	    BFS(0, 0);
	    
	}

	private static void BFS(int startX, int startY) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {startX, startY});
		visited[startX][startY] = true;
		while(!queue.isEmpty()) {
			int[] currNode = queue.poll();
			int currX = currNode[0];
			int currY = currNode[1];

			for(int i = 0; i < 4; i++) {
				int x = currX + dx[i];
				int y = currY + dy[i];
				if(x < 0 || x < 0 || N <= y || M <= y  ) {
					continue;
				}
				if(visited[x][y] || map[x][y] == 0){
					continue;
					
				}
				queue.add(new int[] {x, y});
				map[x][y] = map[currX][currY] +1;
				
				visited[x][y] = true;
			}

			
		}
		
	}

}
