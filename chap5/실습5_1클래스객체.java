package chap5;

class Person {
	
	String name;
	int age;
	float weight;
	
    // 필드
	/*
	 * name은 String, age는 int, weight는 float로 필드 선언
	 */

    // 메소드
    void show() {
    	System.out.println("name = " + name + ", age = " + age + ", weight = " + weight);
    	/*
    	 * name=**, age = **, weight = ** 형태로 출력
    	 */
    }
   
}

public class 실습5_1클래스객체 { // public class는 파일당 하나

	    public static void main(String[] args) {
	        // 객체 생성   	    	
	        Person p = new Person();
	        p.name = "홍길동";
	        p.age = 25;
	        p.weight = 60.56f;

	        // 메소드 호출
	        p.show();
	        
	        Person kang = new Person();
	        
	        kang.name = "강감찬";
	        kang.age = 55;
	        kang.weight = 62.34f;
	        
	        kang.show();
	        
	        /*
	         * [강감찬, 55, 62.34] 객체를 만들어
	         * name=**, age = **, weight = ** 형태로 출력
	         */
	    }
	
}
