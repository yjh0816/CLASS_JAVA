package com.itskb.ws01;

public class ZigZag1 {

	public static void main(String[] args) {
		// input
		int [][] intArray = 
			{
				{1, 2, 3, 4, 5},
				{6, 7, 8, 9, 10},
				{11, 12, 13, 14, 15},
				{16, 17, 18, 19, 20}
			};
		
		// 1. First Idea
//		for(int i=0;i<intArray.length; i++) {
//		if (i%2 == 1) {
//			for(int j=intArray[i].length-1; j>=0; j--) {
//				System.out.print(intArray[i][j] + " ");
//			}
//			System.out.println();				
//		} else {
//			for(int j=0; j<intArray[i].length; j++) {
//				System.out.print(intArray[i][j] + " ");
//			}
//			System.out.println();
//		}
//	}
		
		// 2. My result
		int temp;
		for(int i=0;i<intArray.length; i++) {
			for(int j=0; j<intArray[i].length; j++) {
				if (i%2 == 1) temp = intArray[i].length - 1 - j; 
				else temp = j;
				System.out.print(intArray[i][temp] + " ");
			}
			System.out.println();
		}
	} // end main()
} // end class
