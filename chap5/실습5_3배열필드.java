package chap5;

class Person2 {
	private String name;
	private int age;
	private float weight;
	
	private String[] subjects;
	private int[] years;
	private int index;

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public float getWeight() {
		return weight;
	}
	
	public void setSubjects(int num) {
		this.subjects = new String[num];
	}

	public void setYears(int num) {
		this.years = new int[num];
	}

	
    // 필드 (private)
	/*
	 * name은 String, age는 int, weight는 float로 필드들을 private 선언
	 * subjects을 교육과목 private 배열
     * years을 수강 연도 private 배열
     * count 필드를 사용하여 수강 과목 증가시마다 ++count
	 */
    // 필드

    // 메소드
    void show() {
    	System.out.println("name = " + name + ", age = " + age + ", weight = " +weight);
    	int i = 0;
    	while(i < 3) {
    		System.out.println(subjects[i] + " : "+ years[i]);
    		i++;
    	}
        // 기본 정보 출력::name=**, age=**, weight=**로 출력
       
        // 교육과목 및 수강 연도 출력
    	/*
    	 * while 문을 사용하여 교육과목과 수강연도를 출력
    	 */
    }
    void addSubjectYear(String subject, int year){
    	index++;
    	subjects[index] = subject;
    	years[index] = year;

    }//과목, 수강연도를 매개변수로 전달받아 배열에 추가
}

public class 실습5_3배열필드 {

	    public static void main(String[] args) {
	        // 첫 번째 객체 생성 및 초기화
	        Person2 p1 = new Person2();
	        //다음 코드를 setter, addSubjectYear를 사용하여 수정
	        p1.setName("홍길동");
	        p1.setAge(25);
	        p1.setWeight(60.56f);
	        p1.setSubjects(3);
	        p1.setYears(3);
	        p1.setIndex(-1);
	        for (int i = 0 ; i < 3 ; i++) {
	        	switch(i) {
	        	case 0:
	        		p1.addSubjectYear("Mathematics", 2020); break;
	        	case 1:
	        		p1.addSubjectYear("Science", 2021); break;
	        	case 2:
	        		p1.addSubjectYear("History", 2022); break;
	        	}
	        }
	        //p1.subjects = new String[] {"Mathematics", "Science", "History"};
	       // p1.years = new int[] {2020, 2021, 2022};

	        // 메소드 호출
	        p1.show();
	        
	        // 두 번째 객체 생성 및 초기화
	        Person2 p2 = new Person2();
	        p2.setName("강감찬");
	        p2.setAge(55);
	        p2.setWeight(62.34f);
	        p2.setSubjects(3);
	        p2.setYears(3);
	        p2.setIndex(-1);
		    String[] sub = new String[] {"Literature", "Philosophy", "Physics"};
		    int[] sub1 = new int[] {2018, 2019, 2020};
		    
		    for (int i = 0; i < 3 ; i++) {
		    	p2.addSubjectYear(sub[i], sub1[i]);
		    }
		    p2.show();
	       // p2.name = "강감찬";
	       // p2.age = 55;
	       // p2.weight = 62.34f;
	       // p2.subjects = new String[] {"Literature", "Philosophy", "Physics"};
	       // p2.years = new int[] {2018, 2019, 2020};

	        // 메소드 호출

	    }
}
