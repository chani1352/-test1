package com.ruby.java.ch08.polymorphism;

interface GPI {
	void test();
}

class GP implements GPI {
	public void test() {
		System.out.println("GP test");
	}
}

class PP extends GP {
	public void test() {
		System.out.println("PP test");
	}
	
	public void test1() {
		System.out.println("PP test1");
	}
}

class CD extends PP {
	int a;
	public void test() {
		System.out.println("CD test");
	}
	
	public void test1() {
		System.out.println("CD test1");
	}
	
	public void test2() {
		System.out.println("CD test2");
	}
}

public class Test {
	public static void main(String[] args) {
		CD obj = new CD(); 
		obj.test();
		obj.test1();
		obj.test2();
		
		PP c = new CD(); 
		c.test();
		c.test1();
		//c.test2();

	}

}
