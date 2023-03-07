package com.itskb.ws01;

import java.util.Scanner;

public class RandomUtilTest {

	public static void main(String[] args) {
		RandomUtil r = new RandomUtil();
		Scanner s = new Scanner(System.in);
		System.out.print("Input 2 integer numbers: ");
		int num1 = s.nextInt();
		int num2 = s.nextInt();
		
		int[] result = new int[2];
		
		System.out.println("java.lang.Math.random()");
		for(int i=0; i<100; i++) {
			result[0] = r.getRandomInt1(num1, num2);
			System.out.print(result[0] + " ");			
		}
		System.out.println();
		System.out.println("java.util.Random.nextInt()");
		for(int i=0; i<100; i++) {
			result[1] = r.getRandomInt2(num1, num2);
			System.out.print(result[1] + " ");
		}
	}

}
