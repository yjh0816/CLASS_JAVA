package com.itskb.ws01;

public class ZigZag2 {

	public static void main(String[] args) {
		// input
		int [][] intArray = 
			{
				{1, 2, 3, 4, 5},
				{6, 7, 8, 9, 10},
				{11, 12, 13, 14, 15},
				{16, 17, 18, 19, 20}
			};
		
		// My result
		int temp;
		for(int i=0;i<intArray[0].length; i++) {
			for(int j=0; j<intArray.length; j++) {
				if (i%2 == 1) temp = intArray.length - 1 - j; 
				else temp = j;
				System.out.print(intArray[temp][i] + " ");
			}
			System.out.println();
		}
	}

}
