package day1;

public class DataTypeTest {

	public static void main(String[] args) {
		int i = 300;
		long a = 30L; // 30l;
		a = i; // auto type casting 
		// i = a; impossible
		float b = 3.4F;
		b = i;
		double d = 3.4;
		i = (int)d; // explicit type casting
		
		System.out.println(a +" " + b + " " + d + " " + i);

	}

}
