package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ2504_괄호의값 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		Stack<Character> stack = new Stack<>();

		int result = 0;
		int count = 1;
		for (int i = 0; i < input.length(); i++) {
			char temp = input.charAt(i);
			if(temp == '(') {
				count *= 2;
				stack.add(input.charAt(i));
			}
			else if(temp == '[') {
				count *= 3;
				stack.add(input.charAt(i));
			}
			else if(temp == ')') {
				if(stack.isEmpty() || stack.peek() != '('){
					result = 0;
					break;
				}else if(input.charAt(i-1) == '(') {
					result += count;
				}
				stack.pop();
				count /= 2;
			}
			else if(temp == ']') {
				if(stack.isEmpty() || stack.peek() != '['){
					result = 0;
					break;
				}else if(input.charAt(i-1) == '[') {
					result += count;
				}
				stack.pop();
				count /= 3;
			}
			
		}
		if(!stack.isEmpty()) System.out.println("0");
		else System.out.println(result);
	}

}
