package com.kb.sms;
import java.util.Random;

public class Test2 {

	public static void main(String[] args) {
		Random r = new Random();
		int result = r.nextInt(45) + 1;
		System.out.println(result);
		
		for(int i=0;i<6;i++) {
			result = r.nextInt(45) + 1;
			System.out.print(result + " ");
		}
	}

}
