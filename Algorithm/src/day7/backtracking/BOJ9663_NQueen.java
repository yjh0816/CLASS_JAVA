package day7.backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ9663_NQueen {

	static int N, count = 0;
	static int[] columns;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		columns = new int[N];
		setRowQueen(0);
		System.out.println(count);
	}

	private static void setRowQueen(int cnt) {
		if (cnt == N) {
			count++;
//			System.out.println(Arrays.toString(columns));
			return;
		}
		for (int i = 0; i < N; i++) {
			columns[cnt] = i;
			if (isAvailable(cnt)) setRowQueen(cnt+1);
		}
		
	}

	private static boolean isAvailable(int cnt) {
		for (int i = 0; i < cnt; i++) {
			if (columns[i] == columns[cnt]) return false;
			else if(Math.abs(cnt-i) == Math.abs(columns[cnt]-columns[i])) return false;
		}
		return true;
	}

}
