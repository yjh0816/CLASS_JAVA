package com.kb.sms;
import java.util.Random;
import java.util.Scanner;

public class Test4 {
	static Random r = new Random();

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Input your money for lottery ticket");
		int money = input.nextInt();
		
		for(int j=0; j<money/1000; j++) {
			getNumber();
		}
		// Homework: Eliminate duplicate lottery number 
		
	} // end main()
	public static void getNumber() {
		for(int i=0;i<6;i++) {
			int result = r.nextInt(45) + 1;
			System.out.print(result + " ");
		}
		System.out.println();
	}
} // end class
