package day6.greedy;

import java.util.Scanner;

public class BOJ11047_동전0 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int count = 0;
		int temp;
		for (int i = N - 1; i >= 0; i--) {
			temp = (int)(K / arr[i]);
			if(temp > 0) {
				count += temp;
				K -= temp*arr[i];
			}
		}
		System.out.println(count);
	}

}
