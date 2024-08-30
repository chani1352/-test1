package chap5;

public class StaticMethodTest {
	int num = 123;
	
	public static void main(String[] args) {
		//StaticMethodTest.print1();
		print1();
		
		StaticMethodTest st = new StaticMethodTest();
		st.print2("!");
	}
	
	public static void print1() {
		//int num2 = num;
		System.out.println("hello");
	}
	
	public void print2(String a) {
		//int num3 = num;
		System.out.println("java" + a);
	}

}
