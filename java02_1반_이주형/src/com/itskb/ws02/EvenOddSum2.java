package com.itskb.ws02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EvenOddSum2 {
	public static void main(String[] args) throws FileNotFoundException {
		// Input
		// 1. keyboard
//		Scanner input = new Scanner(System.in);
//		int size = input.nextInt();
//		int[][] su = new int[size][size];
//		for(int r=0; r<size; r++) {
//			for(int c=0; c<size; c++) {
//				su[r][c] = input.nextInt();
//			}
//		}
		// 2. file
		Scanner file = new Scanner(new File("EvenOddSumInput.txt")); // 경로의 기준은 프로젝트 폴더
		int size = file.nextInt();
		int[][] su = new int[size][size];
		for(int r=0; r<size; r++) {
			for(int c=0; c<size; c++) {
				su[r][c] = file.nextInt();
			}
		}
				
		// Processing
		// 1. 2D array 완전 탐색
		int result = 0;
		for(int r=0; r<size; r++) {
			for(int c=0; c<size; c++) {
				// 2. Get UDLR's sum(except out of range)
				int sum = 0;
				if (0 <= c-1) sum += su[r][c-1]; // top
				if (r+1 < size) sum += su[r+1][c]; // right
				if (c+1 < size) sum += su[r][c+1]; // bottom
				if (0 <= r-1) sum += su[r-1][c]; // left
				// 3. If sum is odd, add itself to result
				if (sum % 2 == 0) result += su[r][c];
			}
		}
		// loop1
		
		
		// Output
		// Print result
		System.out.println(result);
	}
}
