package com.kb.arr;

public class Test2 {

	static int[] su = {45,80,77,20,56,87,77,90,15,81};
	public static void main(String[] args) {
		System.out.println("Total: " + getTotal());
		System.out.println("Average: " + getAverage());
		System.out.println("Maximum: " + getMax());
		std();
	}
	public static int getTotal() {
		int sum = 0;
		for(int s: su) {
			sum += s;
		}
		return sum;
	}
	public static double getAverage() {
		int sum = getTotal();
		return sum/(double)su.length;
	}
	public static int getMax() {
		int max = su[0];
		for(int s: su) {
			if (s > max) {
				max = s;
			}
		}
		return max;
	}
	public static void std() {
		// 1. My result
//		double average = getAverage();
//		int max = getMax();
//		int min = su[0];
//		int count = 0;
//		for(int s: su) {
//			if (s < min) {
//				min = s;
//			}
//		}
//		double std = (Math.abs(min-average) > Math.abs(max-average)) ? min : max;
//		
//		for(int s: su) {
//			count++;
//			if (s == std) {
//				break;
//			}
//		}
//		System.out.println("Std count: " + count + "\nStd value: "+ std);
		
		// 2. First idea
//		double std = 0;
//		double result = 0;
////		int count = 0;
//		for(int s: su) {
//			double temp = Math.abs(average-s);
//			if (std < temp) {
//				std = temp;
//				result = s;
//			}
//		}
//		System.out.println("Std: "+ result);
		
		// 3. Teacher's result
		int stdMaxValue = su[0];
		int stdMaxIndex = 0;
		double a = getAverage();
		for(int i=1; i< su.length; i++) {
			if(Math.abs(stdMaxValue-a) < Math.abs(su[i] - a)) {
				stdMaxValue = su[i];
				stdMaxIndex = i;
			}
		}
		System.out.println("Std index: " + stdMaxIndex + "\nStd value: "+ stdMaxValue);
	}
}
