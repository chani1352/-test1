package com.ruby.java.ch13.test;

class Bag<T> {
	private T thing;
		
	public T getThing() {
		return thing;
	}
	
	public void setThing(T thing) {
		this.thing = thing;
	}
	
	void showType() {
		System.out.println("T의 타입은 " + thing.getClass().getName());
	}
}

class Book{}
class PencilCase{}
class Notebook{}

public class BagTest2 {
	public static void main(String[] args) {
		Bag<Book> bag = new Bag<>();
		Bag<PencilCase> bag2 = new Bag<>();
		Bag<Notebook> bag3 = new Bag<>();
		
		Book a = new Book();
		
		bag.setThing(a);
		bag2.setThing(new PencilCase());
		bag3.setThing(new Notebook());
		
		bag.showType();
		bag2.showType();
		bag3.showType();
	}

}
