package com.ruby.java.ch09;

import java.util.StringTokenizer;

public class Test14 {
	public static void main(String[] args) {
		String msg = "Although the world is full of suffering, it is full also of the overcoming of it";
		StringTokenizer st1 = new StringTokenizer(msg);
		System.out.println("단어 수 = " + st1.countTokens());
		
		while(st1.hasMoreTokens()) {  //커서 개념 중요
			System.out.println("남아 있는 토큰 수 = " + st1.countTokens());
			System.out.println(st1.nextToken());
		}
	}

}
