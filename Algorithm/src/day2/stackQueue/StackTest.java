package day2.stackQueue;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		// P1
		
		// 1-1
		Stack<Integer> stack = new Stack<>();
		stack.push(100);
		stack.push(200);
		stack.push(300);
		stack.push(400);
		stack.push(500);
		System.out.println("스택: " + stack.toString());
		
		// 1-2
		int top = stack.pop();
		System.out.println("제거된 값: " + top);
		System.out.println("스택: " + stack.toString());
		
		// 1-3
		top = stack.peek();
		System.out.println("맨 위의 값: " + top);
		
		// 1-4
		while(!stack.isEmpty()) {
			System.out.println("제거된 값: " + stack.pop());
		}
	}

}
