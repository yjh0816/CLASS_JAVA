package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2468_안전영역 {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int max = 0;
	static int[] dy = {0,0,-1,1};
	static int[] dx = {-1,1,0,0};
	static int result = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = map[i][j] > max ? map[i][j] : max;
			}
		}
//		System.out.println(Arrays.deepToString(map));

		for (int c = 0; c < max; c++) {
			int temp = 0;
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] > c && !visited[i][j]) {
						BFS(i,j,c);
						temp++;
					}
				}
			}
			result = temp > result ? temp : result;
		}
		System.out.println(result);
	}

	private static void BFS(int startX, int startY, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {startX, startY});
		visited[startX][startY] = true;
		while(!queue.isEmpty()) {
			int[] currNode = queue.poll();
			int currX = currNode[0];
			int currY = currNode[1];

			for(int i = 0; i < 4; i++) {
				int nextX = currX + dx[i];
				int nextY = currY + dy[i];
				if(0 <= nextX && nextX < N  && 0 <= nextY && nextY < N && map[nextX][nextY] > c && !visited[nextX][nextY]) {
					visited[nextX][nextY] = true;
					queue.offer(new int[] {nextX, nextY});
					
				}
			}
			
		}
		
	}
}
