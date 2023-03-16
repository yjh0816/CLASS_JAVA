package day6;

import java.util.Scanner;

public class BOJ2839_설탕배달 {
	static int S = 3;
	static int L = 5;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = N/S;
		int t_count;
		int temp = N;

		for (int i = 0; i <= N/S; i++) {
			t_count = 0;
			N -= i * S;
			t_count += i;
			if (N / L > 0) {
				t_count += N / L;
				N -= (N / L) * L;
			} 
			if (N == 0) count = count > t_count ? t_count : count;
			else N = temp;
		}
		
//		System.out.println(N + " " + count);
		if (N != 0) System.out.println(-1);
		else System.out.println(count);

	}

}
