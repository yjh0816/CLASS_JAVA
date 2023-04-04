package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13458_시험감독 {
	static int[] arr;
	static int N, A, B;
	static long count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		count = N;
		
		for (int i = 0; i < N; i++) {
			arr[i] -= A;
			if(arr[i] > 0) {
				count += arr[i] / B;
				if(arr[i] % B != 0) count+=1;
			}
			
		}
		System.out.println(count);
	}

}
