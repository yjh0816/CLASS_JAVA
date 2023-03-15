package day4.exhaustiveSearch;

import java.util.Arrays;
import java.util.Scanner;

public class Subset {

	static int N, totalCnt;
	static int[] arr;
	static boolean[] isSelected;
 	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		N = s.nextInt();
		arr = new int[N];
		isSelected = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = s.nextInt();
		}
		subset(0);
	
	}
	
	private static void subset(int cnt) {
		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(isSelected));
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) System.out.println(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		isSelected[cnt] = true;
		subset(cnt+1);
		
		isSelected[cnt] = false;
		subset(cnt+1);
		
	}

}
