package com.itskb.ws01;

import java.util.Random;

public class RandomUtil {
	int getRandomInt1(int from, int to){
		//Math.random()  //0~1  , 1은 포함 안됨
		//Math.random() *(to-from) //to-from 3이라면 0~2.999
		int su=(int)(Math.random()*(to-from+1))+from;//0~1
		return su;
	}
	int getRandomInt2(int from, int to) {
		Random r=new Random();
		int su=r.nextInt(to-from+1)+from;
		return su;
	}
	
}//end class
