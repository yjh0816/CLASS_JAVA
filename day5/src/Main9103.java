import java.util.Scanner;

public class Main9103 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int su = s.nextInt();
		int result = factorial(su);
		System.out.println(result);

	}
	public static int factorial(int num) {
		if (num <= 1) return 1;
		else return num*factorial(--num);
	}

}
