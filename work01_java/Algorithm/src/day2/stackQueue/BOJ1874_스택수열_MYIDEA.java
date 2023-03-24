package day2.stackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1874_스택수열_MYIDEA {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//4 3 6 8 7 5 2 1
		//+ + + + - - + + - + + - - - - -
		//1 2 3 4 5 6 7 8
		//1 2 5 6 
		//4 3 6
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		stack.push(1);
		sb.append("+\n");

		int count = 0, num = 2;

		while(!stack.isEmpty()) {
			if (input[count] == stack.peek()) {
				stack.pop();
				sb.append("-\n");
				count++;
			} else {
				stack.push(num++);
				sb.append("+\n");
			}
			System.out.println(stack.toString());
		}

		if (num-1 != N) System.out.println("NO"); 
		else System.out.println(sb);

	}
	
}
