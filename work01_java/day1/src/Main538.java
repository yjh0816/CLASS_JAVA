import java.util.Scanner;

public class Main538 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int x;
		while(true) {
			System.out.print("number? ");
			x = input.nextInt();
			if (x == 0) break;
			else if (x > 0) {
				System.out.println("positive interger");
			} else {
				System.out.println("negative interger");
			}
		}

	}

}
