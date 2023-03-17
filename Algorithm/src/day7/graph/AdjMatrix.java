package day7.graph;

import java.util.Arrays;
import java.util.Scanner;

public class AdjMatrix {
	
	static int N, E;
	static int[][] adjMatrix;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		E = sc.nextInt();
		adjMatrix = new int[N][N];
		
		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjMatrix[from][to] = 1;
		}
		System.out.println(Arrays.deepToString(adjMatrix));
	} // end main()

} // end class

//7
//8
//0 1
//0 2
//1 3
//1 4
//3 5
//4 5
//5 6
//2 6