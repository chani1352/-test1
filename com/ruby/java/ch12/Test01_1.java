package com.ruby.java.ch12;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test01_1 {

	public static void main(String[] args) {
		System.out.println(args[0]);
		System.out.println(args.length);
		if (args.length != 2) {
			System.out.println("  ");
			return;
		}

		long start = System.currentTimeMillis();
		copyfile(args[0], args[1]);
		System.out.println("copyFile : " + (System.currentTimeMillis() - start));
		start = System.currentTimeMillis();
		copyfile1(args[0], args[1]);
		System.out.println("copyFile1 : " + (System.currentTimeMillis() - start));

	}

	public static void copyfile(String string, String string1) {
		try (FileInputStream fi = new FileInputStream(string); FileOutputStream fo = new FileOutputStream(string1);) {
			int c = 0;
			while ((c = fi.read()) != -1) { // 파일 사이즈가 증대시 속도 느려짐 (1byte씩 복사) -> 필터스트림 사용 (메모리에 8k byte씩 올린 후 메모리에서 꺼내씀
											// -> 속도빠름)
				fo.write(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void copyfile1(String string, String string1) {
		try (BufferedInputStream fi = new BufferedInputStream(new FileInputStream(string));
				BufferedOutputStream fo = new BufferedOutputStream(new FileOutputStream(string1));) {
			int c = 0;
			while ((c = fi.read()) != -1) { // 파일 사이즈가 증대시 속도 느려짐 (1byte씩 복사) -> 필터스트림 사용 (메모리에 8k byte씩 올린 후 메모리에서 꺼내씀
											// -> 속도빠름)
				fo.write(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
