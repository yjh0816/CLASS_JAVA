package com.kb.algo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		// 1. 키보드 입력
//		Scanner s = new Scanner(System.in);
		// 2. 파일 입력(편리)
//		Scanner s = new Scanner(new File("input.txt"));
		// 3. 파일 입력(편리2)
		/*
		System.setIn(new FileInputStream("input.txt"));
		Scanner s = new Scanner(System.in);
		int su = s.nextInt();
		int su2 = s.nextInt();
		System.out.println(su + " " + su2);
		*/
		// 4. 파일 입력(성능)
//		FileInputStream fis = new FileInputStream("input.txt"); // file에서 8bit씩 읽음
//		// 그러나 우리는 한글이 16bit 사용
//		InputStreamReader isr = new InputStreamReader(fis); // 8bit -> 16bit 로 변경
//		BufferedReader br = new BufferedReader(isr); // 입출력 속도차를 위해서 버퍼를 제공
		BufferedReader br = new BufferedReader(
							new InputStreamReader(
							new FileInputStream("input.txt")));
		String data = br.readLine();
		System.out.println(data);
		String[] d = data.split(" ");
		int[] sd = new int[d.length];
		for(int i=0; i<d.length; i++) {
			sd[i] = Integer.parseInt(d[i]);
		}
		System.out.println(Arrays.toString(sd));
		
	} // end main()

} // end class
