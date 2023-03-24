package day1.array;

import java.util.Arrays;

public class Array {

	public static void main(String[] args) {
		// P1
		System.out.println("==============P1==============");
		int[] arr = {100,200,300,400,500};
		// 1-1
		System.out.println(arr[2]);
		// 1-2
//		for (int i = 0; i < arr.length; i++) {
//			if (arr[i] == 400) {
//				arr[i] = 999;
//			}
//		}
		arr[3] = 999;
		System.out.println(Arrays.toString(arr));
		// 1-3
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		// P2
		System.out.println("==============P2==============");
		int[][] arr2 = {{1,2,3},{4,5,6},{7,8,9}};
		// 2-1
		System.out.println(Arrays.deepToString(arr2));
		// 2-2
		arr2[1][1] = 999; 
		System.out.println(Arrays.deepToString(arr2));
	}

}
