package day1;

public class LoopTest2 {

	public static void main(String[] args) {
		// 1~100 even sum
		int sum = 0;
		for(int i=1; i<=100; i++) {
			if (i % 2 == 0) {
				sum += i;
			}
		}
		System.out.println(sum);
		
		// v2
		sum = 0;
		for(int i=2; i<=100; i+=2) {
			sum += i;
		}
		System.out.println(sum);
		
		// v3
		/*
		1+100, 2+99 ...
		(1+100) * 50 / 2
		*/
		
		// 1~100 sum of multiple of 3, 
		// but, when multiple of 3 is multiple of 5, exit
		// 3 6 9 12 15
		sum = 0;
		for(int i=3; i<=100; i+=3) {
			sum += i;
			if (i % 5 == 0) break;
		}
		System.out.println(sum);
		
		// 1~100 sum of multiple of 3, 
		// but, when multiple of 3 is multiple of 5, don't add
		// 3 6 9 12 18 21 24 27 ...
		sum = 0;
		for(int i=3; i<=100; i+=3) {
			if (i % 5 == 0) continue;
			sum += i;
		}
		System.out.println(sum);
		
	} // end main()

} // end class
