package day1;

public class IfTest {

	public static void main(String[] args) {
		int score = 77;
		// if 1
		if (score > 70) {
			System.out.println("Pass~~~");
		}
		// if 2
		if (score > 80) {
			System.out.println("Pass");
		} else {
			System.out.println("Non-Pass:(");
		}
		// if 3
		if (score >= 90) {
			System.out.println("grade A");
		} else if (score >= 80) {
			System.out.println("grade B");
		} else if (score >= 70) {
			System.out.println("grade C");
		} else {
			System.out.println("grade F");
		}
		// switch
		switch (score/10) {
			case 10:
			case 9:
				System.out.println("grade A");
				break;
			case 8:
				System.out.println("grade B");
				break;
			case 7:
				System.out.println("grade C");
				break;
			default:
				System.out.println("grade F");
		}
		// 3항 연산
		int result = (score > 70) ? 100 : 0; //(state)?true:false
		System.out.println(result);
		
	} // end main()

} // end class
