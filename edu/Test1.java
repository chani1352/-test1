package edu;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름 :");
		String name = sc.next();
		
		System.out.println("나이 :");
		int age = sc.nextInt();
		
		System.out.println("이름 : "+ name);
		System.out.println("나이: "+ age);
		System.out.println("생년월일 : 2020.0101");
		System.out.println("학교 : 부산대학교");
		System.out.println("학과 : 컴퓨터공학과");
		System.out.println("입학 : 2020년");
		
		sc.close();

	}

}
