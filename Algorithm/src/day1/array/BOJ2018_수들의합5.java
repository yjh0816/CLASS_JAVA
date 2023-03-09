package day1.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2018_수들의합5 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int start = 1;
		int end = 1;
		int sum = 1;
		int count = 0;
		
		while(start <= end) {
			if (sum == N) {
				count++;
			} 
			if (sum < N) {
				end++;
				sum += end;
			} else if (sum >= N) {
				sum -= start;
				start++;
			}

		}
		System.out.println(count);
		
	}
	
}
