package com.itskb.ws01;

import java.util.Random;
import java.util.Scanner;

public class RandomUtil {
	static Random r = new Random();
	public static int getRandomInt1(int from, int to) {
		double f = Math.random()/Math.nextDown(1.0);
		double x = from*(1.0 - f) + to*f;
		return (int) x;
	}
	public static int getRandomInt2(int from, int to) {
		int result = r.nextInt(from, to);
		return result;
	}
}
