package com.itskb.ws01;

import java.util.Random;
import java.util.Scanner;

public class RandomUtil {

	public static int getRandomInt1(int num1, int num2) {
		double f = Math.random()/Math.nextDown(1.0);
		double x = num1*(1.0 - f) + num2*f;
		return (int) x;
	}
	public static int getRandomInt2(int num1, int num2) {
		Random r = new Random();
		int result = r.nextInt(num1, num2);
		return result;
	}
}
