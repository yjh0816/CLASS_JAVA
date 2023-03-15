package test.algorithm;

import java.util.Scanner;

public class kb1반_알고리즘2번_이주형 {
	
	static int[] numbers, arr;
	static int N, M, ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		ans = 0;
		arr = new int[N];
		numbers = new int[3];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		comb(0, 0);

		System.out.println(ans);
	}
	 private static void comb(int cnt, int startIndex) {
        if (cnt == 3) {
        	if (numbers[0] + numbers[1] + numbers[2] < M) {
        		ans = ans < numbers[0] + numbers[1] + numbers[2] ? numbers[0] + numbers[1] + numbers[2] : ans;
//		            System.out.println(Arrays.toString(numbers));
        	}
        	return;
        }

        for (int i = startIndex; i < N; i++) {
            numbers[cnt] = arr[i];
            comb(cnt+1, i+1);
        }
    }

}
