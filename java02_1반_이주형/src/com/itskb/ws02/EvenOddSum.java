package com.itskb.ws02;

public class EvenOddSum {
	static int len = 6;
	static int[][] arr = {
			{1, 2, 5, 7, 3, 4},
			{3, 1, 9, 8, 4, 5},
			{6, 2, 4, 6, 2, 8},
			{9, 7, 4, 3, 7, 8},
			{2, 3, 4, 8, 4, 6},
			{4, 6, 2, 3, 7, 8}
	};
	public static void main(String[] args) {
		int[] dy = {0, -1, 1, 0};
		int[] dx = {-1, 0, 0, 1};
		int result = 0;
		for(int i=0; i<len; i++) {
			for(int j=0; j<len; j++) {
				int temp = 0;
				for(int d=0; d<4; d++) {
					if (0 <= i+dx[d] && i+dx[d] < len && 0 <= j+dy[d] && j+dy[d] < len) {
						temp += arr[i+dx[d]][j+dy[d]];
					}
				}
//				System.out.print(temp + " ");
				if (temp % 2 == 0) {
//					System.out.print(temp + " ");
//					result += temp;
					result += arr[i][j];
				}
				
			}
		}
		System.out.println(result);
	}
}
