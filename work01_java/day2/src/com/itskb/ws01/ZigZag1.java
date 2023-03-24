package com.itskb.ws01;

public class ZigZag1 {

	public static void main(String[] args) {
		int[][] intArray= {
				{1,2,3,4,5},
				{6,7,8,9,10},
				{11,12,13,14,15},
				{16,17,18,19,20}
		};
		
		int row= intArray.length;  //행의 길이 4
		int col= intArray[0].length;  //열의 길이 5
		
		for( int r=0; r<row; r++) {
			if(r%2==0) {  //행의 인덱스가 짝수라면
				for(int c=0; c<col; c++) {
					System.out.print(intArray[r][c]+" ");
				}
			}else {  //행의 인덱스가 홀수라면
				for(int c=col-1; c>=0; c--) {
					System.out.print(intArray[r][c]+" ");
				}
			}
			System.out.println();//줄바꿈
		}
		

	}//end main
}//end class
