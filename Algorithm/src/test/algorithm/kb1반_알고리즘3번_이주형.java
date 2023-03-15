package test.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class kb1반_알고리즘3번_이주형 {
	final static int N = 19;
	final static int R = 5;
    static int[] locationX, locationY;
    static int[][] input;
    static boolean[][] isSelected;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        input = new int[N][N];
        isSelected = new boolean[N][N];
        locationX = new int[R];
        locationY = new int[R];
        for (int i = 0; i < N; i++) {
        	for (int j = 0; j < N; j++) {
                input[i][j] = sc.nextInt();
        	}
        }
        
        comb(0, 0, 0);
//        System.out.println(N + "P" + R + " = " + totalCnt);
        
    }
    
    private static void comb(int cnt, int xIndex, int yIndex) {
        if (cnt == 5) {
    	    System.out.println(Arrays.toString(locationX));
            System.out.println(Arrays.toString(locationY));
            return;
        }

        for (int i = xIndex; i < N; i++) {
        	for (int j = yIndex; j < N; j++) {
        		if (input[i][j] == 1) {
    	            locationX[cnt] = i+1;
    	            locationY[cnt] = j+1;
    	            comb(cnt+1, xIndex, yIndex+1); // 다음 카드 선택
        		}
        	}
        }
    }
}
