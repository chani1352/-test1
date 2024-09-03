package chap6;

class Student1 {
	
	private String name;
	private int age;
	private String[] subjects;
	private int[] scores;
	private int count;
	private int[] passFails;
	public static int numberStudent ;
	
	public Student1(String name, int age, String[] subjects, int[] scores, int count) {
		setName(name);
		setAge(age);
		setSubjects(subjects);
		setScores(scores);
		setCount(count);
		numberStudent++;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setSubjects(String[] subjects) {
		this.subjects = subjects;
	}
	public void setScores(int[] scores) {
		this.scores = scores;
	}
	
	public void setCount(int num) {
		count = subjects.length;
	}
	
	public boolean isPassed(int num) {
		if(passFails[num] <= scores[num] ) {
			return true;
		} else {
			return false;
		}
	}
	
    public void printStudent() {
    	System.out.println("이름 = " + name + ", 나이 = " + age);
    	for(int i = 0 ; i < count ; i++) {
    		System.out.println("과목"+ (i+1) + " = " + subjects[i] + ", 점수" + (i+1) + " = " + scores[i]);    		
    	}	
    }

    public void printStudentInfo() {
    	System.out.println("이름 = " + name + ", 나이 = " + age);
    	String pf;
    	for(int i = 0 ; i < count ; i++) {
    		if(isPassed(i)) {
    			pf = "pass";
    		}else {
    			pf ="fail";
    		}
    		System.out.println("과목"+ (i+1) + " = " + subjects[i] + ", 점수" + (i+1) + " = " + scores[i] + " , 통과여부 = " + pf);    		
    	}
    }
}




public class 실습6_2생성자사용 {
	public static void showStudents(Student1[] students) {
		for (Student1 s : students) {
			s.printStudent();
			System.out.println("-".repeat(20));
		}
	}
	
    public static void main(String[] args) {
        String[] subjects = {"수학", "국어", "영어", "과학", "역사"};

        Student1[] students = {
         new Student1 ("홍길동", 21, subjects, new int[]{85, 90, 78, 88, 92}, 1),
         new Student1 ("김유신", 22, subjects, new int[]{75, 80, 85, 90, 95}, 1),
         new Student1 ("계백", 23, subjects, new int[]{65, 70, 75, 80, 85}, 1),
         new Student1 ("강감찬", 24, subjects, new int[]{95, 92, 88, 84, 91}, 1),
         new Student1 ("을지문덕", 25, subjects, new int[]{88, 76, 85, 79, 90}, 1) 
        };
       
       showStudents(students);
    }
}
