package com.ruby.java.ch09;

public class Test {
	public static void main(String[] args) {
		String a = "10";
		
		int b = Integer.parseInt(a);
		//Integer b1 = Integer.valueOf(b);
		Integer b1 = b;
		//int c = b1.intValue();
		int c = b1;
		System.out.println(b1);
	}
}
