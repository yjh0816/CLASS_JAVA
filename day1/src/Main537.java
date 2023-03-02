import java.util.Scanner;

public class Main537 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int x = input.nextInt();
		int sum = 0;
		int i = 1;
		while(i <= x) {
			sum += i++;
		}
		System.out.println(sum);
	}

}
