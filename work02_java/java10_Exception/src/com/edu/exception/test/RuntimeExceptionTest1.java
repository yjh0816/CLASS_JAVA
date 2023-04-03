package com.edu.exception.test;
/*RuntimeException
 * 컴파일 O (컴파일러가 인식을 못함)
 * 실행시 X
 * 
 * 명시적으로 예외를 처리(try~catch)할 필요가 없다.
 * 코드를 수정
 */
public class RuntimeExceptionTest1 {

	public static void main(String[] args) {
		String[] str = {
			"Hello",
			"No, I mean it",
			"Nice to meet you"
		};
		int i = 0;
		while(i<=3) {
			try {
				System.out.println(str[i]);
			} catch(ArrayIndexOutOfBoundsException e) {
				//예외 잡혔을 때의 코드
				System.out.println("Nice Catch~!!");
			} catch(ArithmeticException e) {
				System.out.println("Nice Catch~!!");
			} catch(Exception e) {
				System.out.println("Nice Catch~!!");
			}
			i++;								
		}
		
		System.out.println("while looping end....");

	}

}
