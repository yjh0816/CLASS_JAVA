package day1.array;

import java.util.Scanner;

public class BOJ11659_구간합구하기4 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int num2 = input.nextInt();
		
		int[] arr = new int[num + 1];
		for (int i = 1; i < arr.length; i++) {
			arr[i] = input.nextInt();
		}
		
		int[][] arr2 = new int[num2][2];
		for (int i = 0; i < arr2.length; i++) {
			for(int j = 0; j < 2; j++) {
				arr2[i][j] = input.nextInt();
			}
		}
		// arr배열을 사용하지 않기 때문에 메모리 관리상 합배열을 만들 필요가 없음
//		int[] sum = arr.clone();
//		for (int i = 1; i < sum.length; i++) {
//			sum[i] += sum[i-1];
//		}
		for (int i = 1; i < arr.length; i++) {
			arr[i] += arr[i-1];
		}
		// ex) S(5) - S(4) = a(5)
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr[arr2[i][1]] - arr[arr2[i][0] - 1]);
		}
		// O(n) 방식: 시간초과
//		for (int i = 0; i < arr2.length; i++) {
//			for(int j = arr2[i][0] - 1; j <= arr2[i][1] - 1; j++) {
//				sum += arr[j];
//			}
//			System.out.println(sum);
//			sum = 0;
//		}
		
		
	}

}
