package day3.sort;

import java.util.Arrays;

public class BubbleSort {
	static int[] arr = {7, 2, 8, 1, 6, 3, 5};
	public static void main(String[] args) {
		bubbleSort();
		System.out.println(Arrays.toString(arr));
	}
	private static void bubbleSort() {
		for (int i = 0; i <= arr.length - 2; i++) {
			for (int j = 0; j <= arr.length - i - 2; j++) {
				if (arr[j] > arr[j+1]) {
					swap(j, j+1);
				}
			}
		}
	}
	private static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
