package com.ruby.java.ch12.serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//Book 클래스
class Book implements Serializable{
	private String title;
	private String author;
	private int publicationYear;
	private String isbn;

	public Book(String title, String author, int publicationYear, String isbn) {
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.isbn = isbn;
	}
	
	public String toString() {
		return "도서명 =" + title + ", 저자 = " + author + ", 출판연도 = " + publicationYear + ", isbn = " + isbn;
	}
	

}

class Library implements Serializable {
	static final int CAPACITY = 5; // 기본 용량을 5로 설정
	private Book[] books;
	private int top = 0;
	
	public Library() {
		books = new Book[CAPACITY];
	}

	public void addBook(Book books) {
		this.books[top] = books;
		top++;
	}
	
	public void printBooks(String str) {
		System.out.println(str);
		for(int i = 0 ; i < top ; i++) {
			System.out.println(books[i].toString());
		}
	}

}

public class 실습12_1_입출력_과제 {

	private static void saveLibrary(Library library, String filename) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
			out.writeObject(library);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Library loadLibrary(String string) {
		Library user = new Library();
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(string))) {
				user = (Library) in.readObject();

		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return user;
	}

	public static void main(String[] args) {

		Library library = new Library();

		// 5개의 Book 객체 배열 저장
		library.addBook(new Book("자바", "강감찬", 1995, "12"));
		library.addBook(new Book("파이썬", "이순신", 2008, "9"));
		library.addBook(new Book("자바스크립트", "을지문덕", 2008, "8"));
		library.addBook(new Book("자료구조", "연개소문", 1994, "45"));
		library.addBook(new Book("리액트", "김춘추", 1999, "7"));

		// 현재 도서 목록 출력
		library.printBooks("현재 도서 목록:");

		// 라이브러리 저장
		saveLibrary(library, "library.dat");

		System.out.println("-".repeat(80));

		Library lib = loadLibrary("library.dat");

		// 최종 도서 목록 출력
		lib.printBooks("최종 도서 목록:");
	}
}