package day1.array;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ11660_구간합구하기5_MYIDEA {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int M = input.nextInt();
		int[][] map = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = input.nextInt();
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i >= 2 && j == 1) { map[i][j] += map[i-1][N]; }
				else { map[i][j] += map[i][j-1]; }
			}
		}
		System.out.println(Arrays.deepToString(map));
		for (int i = 0; i < M; i++) {
			int x1 = input.nextInt();
			int y1 = input.nextInt();
			int x2 = input.nextInt();
			int y2 = input.nextInt();
			
			if (x1 == x2 && y1 == 1) {
				y1 = N;
				x1--;
			}
			else if (x1 == x2 && y1 == y2) {
				y1--; 
			} 
			System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);
			System.out.println(map[x2][y2] +" "+ map[x1][y1]);
			System.out.println(map[x2][y2] - map[x1][y1]);
		}
		
	}
	
}
