package chap6;

class Student {
	
	private String name;
	private int age;
	private String[] subjects;
	private int[] scores;
	private int value;
	
	
	void setName(String name) {
		this.name = name;
	}
	void setAge(int age) {
		this.age = age;
	}
	void setSubjects(String subjects[]) {
		this.subjects = subjects;
	}
	void setScores(int scores[]) {
		this.scores = scores;
	}
	void setValue(int value) {
		this.value = subjects.length;
	}

    public void printStudent() {
       	System.out.println("이름 = " + name + ", 나이 = " + age );
    	for(int i = 0 ; i < value ; i++) {
    		System.out.println("과목"+ (i+1) + "= " + subjects[i] + ", 점수"+ (i+1)+ "= " + scores[i]);
    	}
    	
    }
}

public class 실습6_1객체생성자미사용 {
    static Student makeStudent(String name, int age, String[] subjects, int[] scores, int value) {
    	Student s = new Student();
    	s.setName(name);
    	s.setAge(age);
    	s.setSubjects(subjects);
    	s.setScores(scores);
    	s.setValue(value);    	
        return s;
    }
    
    public static void showStudents(Student[] students) {
    	//for(int i = 0 ; i < 5 ; i++) {
    	//	students[i].printStudent();
    	//	System.out.println();    		
    	//}
    	for (Student s : students) {
    		s.printStudent();
    		System.out.println("-".repeat(20));
    	}
    	
    }
    
	public static void main(String[] args) {
        String[] subjects = {"수학", "국어", "영어", "과학", "역사"};

        Student[] students = {
            makeStudent("홍길동", 21, subjects, new int[]{85, 90, 78, 88, 92}, -1),
            makeStudent("김유신", 22, subjects, new int[]{75, 80, 85, 90, 95}, -1),
            makeStudent("계백", 23, subjects, new int[]{65, 70, 75, 80, 85}, -1),
            makeStudent("강감찬", 24, subjects, new int[]{95, 92, 88, 84, 91}, -1),
            makeStudent("을지문덕", 25, subjects, new int[]{88, 76, 85, 79, 90}, -1)
        };

        showStudents(students);
        
    }

	
}
