package day3.sort;

import java.util.Scanner;

public class BOJ2750_수정렬하기 {
	
	static Scanner s = new Scanner(System.in);
	static int N = s.nextInt();
	static int[] arr = new int[N];
	public static void main(String[] args) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = s.nextInt();
		}
		bubbleSort();
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}
	private static void bubbleSort() {
		for (int i = 0; i <= arr.length - 2; i++) {
			for (int j = 0; j <= arr.length - i - 2; j++) {
				if (arr[j] > arr[j+1]) swap(j, j+1);
			}
		}
	}
	private static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp; 
	}

}
