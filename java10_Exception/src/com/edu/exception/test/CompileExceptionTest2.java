package com.edu.exception.test;
import java.io.FileNotFoundException;
/*
 CompileException
 1. 컴파일 X :: 컴파일러가 인식
 2. 반드시 명시적으로 예외처리해서 사용해야하는 일종의 문법구조
 */
import java.io.FileReader;

class FileReading {
	public void readFile(String fileName) {
		try {
			FileReader reader = new FileReader(fileName); //CompileException
			System.out.println("1. 파일을 잘 찾았습니다.");
		} catch (FileNotFoundException e) {
			System.out.println("1. 파일을 찾을 수 없습니다.");
		}
		System.out.println("2. FileReader API Creating...");
	}
}
public class CompileExceptionTest2 {
	public static void main(String[] args) {
		FileReading fr = new FileReading();
//		fr.readFile("C:\\KB\\workshop_homework\\java_r_01\\java_r1_Workshop.pdf");
		fr.readFile("C:\\KB\\workshop_homework\\java_r_0\\java_r1_Workshop.pdf");
		
		System.out.println("3. 파일을 잘 읽어들였습니다.");
	}
}
