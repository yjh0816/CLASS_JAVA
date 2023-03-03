package com.kb.arr;

public class Test3 {

	public static void main(String[] args) {
		int[] a = {10,20,30};
		System.out.println(a[1]);
		System.out.println(a.length);
		
		int[][] b = {{10,20,30},{11,22,33}};
		System.out.println(b[1][0]);
		System.out.println(b.length);
		System.out.println(b[0].length);
		// foreach
		for(int[] bb: b) {
			for(int bbb: bb) {
				System.out.print(bbb + " ");
			}
			System.out.println();
		}
		// for
		for(int r=0; r< b.length; r++) {
			for(int c=0; c<b[r].length; c++) {
				System.out.print(b[r][c] + " ");
			}
			System.out.println();
		}
		
	} // end main()

} // end class
