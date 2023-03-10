package day2.stackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1874_스택수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}

		int count = 0, num = 1;

		while(num <= N) {
			if (stack.isEmpty() || stack.peek() != input[count]) {
				stack.push(num++);
				sb.append("+\n");
			}
			if (input[count] == stack.peek()) {
				stack.pop();
				sb.append("-\n");
				count++;
			} 

		}
		while(!stack.isEmpty()) {
			if(stack.peek() != input[count]) break;
			stack.pop();
			sb.append("-\n");
			count++;
		}

		if (count != N) System.out.println("NO"); 
		else System.out.println(sb);

	}
	
}
