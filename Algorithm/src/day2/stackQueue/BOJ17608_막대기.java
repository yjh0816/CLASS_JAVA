package day2.stackQueue;

import java.util.Scanner;
import java.util.Stack;

public class BOJ17608_막대기 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < N; i++) {
			stack.push(input.nextInt());
		}

		int top = stack.pop();
		int temp = 0;
		int count = 1;
		while(!stack.isEmpty()) {
			temp = stack.pop();
			if (top < temp) {
				top = temp;
				count++;
			} 
		}
		System.out.println(count);
	}
	
}
