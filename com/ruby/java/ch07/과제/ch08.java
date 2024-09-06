package com.ruby.java.ch07.과제;

abstract class Employee{
	static int count = 0; // 클래스 필드
	int eno;
	abstract void calcSalary();

}

class Salesman extends Employee{

	@Override
	void calcSalary() {
		// TODO Auto-generated method stub
		
	}
	
	static void ShowCount() {
		System.out.println("카운트 = " + count);
	}
	
}


public class ch08 {
	
	void show() {
		
	}
	
	static void calcTax() { //정적 메소드, 클래스 메소드
		
	}
	public static void main(String[] args) {
	
	}

}

