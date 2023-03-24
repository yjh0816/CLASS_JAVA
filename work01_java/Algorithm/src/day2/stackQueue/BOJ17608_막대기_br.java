package day2.stackQueue;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ17608_막대기_br {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < N; i++) {
			stack.push(Integer.parseInt(br.readLine()));
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
