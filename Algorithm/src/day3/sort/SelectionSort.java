package day3.sort;

import java.util.Arrays;

public class SelectionSort {
	static int[] arr = {7, 2, 8, 1, 6, 3, 5};
	public static void main(String[] args) {
		selectionSort();
		System.out.println(Arrays.toString(arr));

	}
	private static void selectionSort() {
		for (int i = 0; i < arr.length; i++) {
			int minIdx = i;
			for (int j = i+1; j < arr.length; j++) {
				if (arr[j] < arr[minIdx]) minIdx = j;
			}
			swap(minIdx, i);
		}
	}
	private static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
