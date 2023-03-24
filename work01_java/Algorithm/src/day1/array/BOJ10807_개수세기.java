package day1.array;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
import java.util.Scanner;

public class BOJ10807_개수세기 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int[] arr = new int[num];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = input.nextInt();
		}
		
		int find = input.nextInt();
		
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == find) count++;
		}
		System.out.println(count);
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		int num = Integer.parseInt(br.readLine());
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int[] arr = new int[num];
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = Integer.parseInt(st.nextToken());
//		}
//		
//		int find = Integer.parseInt(br.readLine());
//		
//		int count = 0;
//		for (int i = 0; i < arr.length; i++) {
//			if (arr[i] == find) count++;
//		}
//		System.out.println(count);
	}

}
