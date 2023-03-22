package test2.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class kb1반_알고리즘3번_이주형 {
    
	static int R, C;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,0,1};
	static int[] dy = {1,1,1};
	static int count = 0;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
	    	String s = br.readLine();
			for (int j = 0; j < C; j++) {
				if (s.charAt(j) == '.') map[i][j] = 1;
				else if (s.charAt(j) == 'x') map[i][j] = 0;
			}
		}

		visited[0][0] = true;
		for (int i = 0; i < R; i++) {
			DFS(i, 0);
		}
		
//		for (int i = 0; i < R; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		
		System.out.println(count);
		
    }

    
    private static void DFS(int currX, int currY) {
//		System.out.print(map[currX][currY]);
		for (int i = 0; i < 3; i++) {
			int nextX = dx[i]+currX;
			int nextY = dy[i]+currY;
			if (0 <= nextX && 0 <= nextY && nextX < R && nextY < C && map[nextX][nextY] == 1 && !visited[nextX][nextY]) {
				visited[nextX][nextY] = true;
				map[nextX][nextY] = map[currX][currY] + 1;
				if (nextY == C-1) {
					count++;
					return;
				}
				DFS(nextX,nextY);
			}
		}
	}

}
