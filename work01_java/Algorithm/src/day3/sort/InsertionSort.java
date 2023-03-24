package day3.sort;

import java.util.Arrays;

public class InsertionSort {
	static int[] arr = {7, 2, 8, 1, 6, 3, 5};
	public static void main(String[] args) {
		insertionSort();
		System.out.println(Arrays.toString(arr));
	}
	
	private static void insertionSort() {
		for (int i = 1; i < arr.length; i++) {
			int insertIdx = i;
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[i]) {
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
