package day1;

public class LoopTest {

	public static void main(String[] args) {
		// for
		for(int i=0; i<10; i++) {
			System.out.println("****");
//			System.out.println(i);
		}
		
		int dan = 3;
		for(int i=1; i<10; i++) {
			System.out.println(dan + "*" + i + "=" + (dan * i));
		}
		// full 99dan
		for(int i=2; i<10; i++) {
			for(int j=1; j<10; j++) {
				System.out.println(i + "*" + j + "=" + (i*j));
			}
			System.out.println();
		}
		
		// for ~ each
		int[] su = {30,70,20,80,10};
		for (int i=0; i<su.length; i++) {
			System.out.print(su[i] + " ");
		}
		System.out.println();
		for (int s : su) {
			System.out.print(s + " ");
		}
		System.out.println();
		
		/*
		boolean state = false;
		// while
		while (state) {
			
		}
		// do~ while
		do {
			
		} while (state);
		*/
		
	} // end main()

} // end class
