package test.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class kb1반_알고리즘1번_이주형 {

	static int[] arr;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		insertionSort();
		System.out.println(Arrays.toString(arr));
	}
	
	private static void insertionSort() {
		for (int i = 1; i < arr.length; i++) {
			int insertIdx = i;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					insertIdx = j;
					break;
				}
			}
			int temp = arr[i];
			for (int j = i-1; j >= insertIdx; j--) {
				arr[j+1] = arr[j];
			}
			arr[insertIdx] = temp;
		}
	}

}
