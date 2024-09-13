package com.ruby.java.ch13.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;



@Retention(RetentionPolicy.RUNTIME)
@interface Check{
	String name();
	int val();
	int repeat() default 5;   // 아래 어노테이션 사용 시 해당 메소드 값 선언 안할때 default로 기본 값 선언 가능, 선언 후 값 변경 가능
}

public class AnnoTest {
	
	@Check(name = "first", val=123, repeat = 10)
	public static void test() {
		AnnoTest obj = new AnnoTest();
		try {
			Class<?> c = obj.getClass();
			System.out.println(obj.getClass());
			System.out.println("c : " + c);
			Method m = c.getMethod("test");	
			System.out.println("m :" + m);
			Check check = m.getAnnotation(Check.class);
			System.out.println("check :" + check);
			
			for(int i = 0 ; i < check.repeat(); i++) {
				System.out.println(check.name() + " : " + check.val());
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		test();
	}

}
