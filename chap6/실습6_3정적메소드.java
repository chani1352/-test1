package chap6;

class Student2 {
	
	private String name;
	private int age;
	private String[] subjects;
	private int[] scores;
	private int[] passFails;
	private int count;
	public static int numberStudents;
	
	public Student2(String name, int age, String[] subjects, int[] scores, int[] passFails,int count) {
		setName(name);
		setAge(age);
		setSubjects(subjects);
		setScores(scores);
		setPassFails(passFails);
		setCount(count);	
		numberStudents++;
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
	public void setPassFails(int[] passFails) {
		this.passFails = passFails;
	}
	public void setCount(int num) {
		this.count = subjects.length;
	}
	

	public void printStudent() {
		count = subjects.length;
    	System.out.println("이름 = " + name + ", 나이 = " + age);
    	for(int i = 0 ; i < subjects.length ; i++) {
    		System.out.println("과목"+ (i+1) + " = " + subjects[i] + ", 점수" + (i+1) + " = " + scores[i]);
    	}
    	System.out.println();
	}

	public void printStudentInfo() {
    	System.out.println("이름 = " + name + ", 나이 = " + age);
    	for(int i = 0 ; i < subjects.length ; i++) {
    		String pf = (scores[i] >= passFails[i]) ? "pass" : "fail";
    		System.out.println("과목"+ (i+1) + " = " + subjects[i] + ", 점수" + (i+1) + " = " + scores[i] + " , 통과여부 = " + pf);    		
    	}

	}

	public boolean isPassed() {
		for(int i = 0 ; i < subjects.length ; i++) {
			if(passFails[i] > scores[i] ) {
				return false;
			} 
		}
		return true;
	}

	public static void printAllStudents(Student2[] students) {
		for (int i = 0 ; i < Student2.numberStudents ; i++) {
			System.out.println("이름 : " + students[i].name + ", 나이 = " + students[i].age);
			for ( int j = 0 ; j < students[i].subjects.length ; j++) {
				String pf = (students[i].scores[j] >= students[i].passFails[j]) ? "pass" : "fail";
				System.out.println( "과목 명 = " + students[i].subjects[j] + " , 과목 점수 : " + students[i].scores[j] + " , 과목 통과 여부 : " + pf);
			}
			System.out.println("전체 과목 통과 여부" + "\t" + (students[i].isPassed()?"pass" : "fail"));
			System.out.println();
		}
	}
	
	public static void printSubjectStats(Student2[] students) {
		int max = 0;
		String maxName = null;
		int min = 100;
		String minName = null;
			
		System.out.println("최고 점수");
		for(int i = 0 ; i < Student2.numberStudents ; i++) {
			for(int j= 0 ; j < students[i].subjects.length ; j++) {
				if (students[j].scores[i] > max) {
					max = students[j].scores[i] ;
					maxName = students[j].name;
				}		
			}
		System.out.println("과목 명 : " + students[i].subjects[i] + ", 과목 점수 :" + max + ", 이름 : " + maxName);
		max = 0;
		maxName = null;
		}
		
		System.out.println("최저 점수");
		for(int i = 0 ; i < Student2.numberStudents ; i++) {
			for(int j= 0 ; j < students[i].subjects.length ; j++) {
				if (students[j].scores[i] < min) {
					min = students[j].scores[i] ;
					minName = students[j].name;
				}		
			}
		System.out.println("과목 명 : " + students[i].subjects[i] + ", 과목 점수 :" + min + ", 이름 : " + minName);
		min = 100;
		minName = null;
		}		
	}
	
	public static void printTable(Student2[] students) {
		System.out.println("=".repeat(100));
		System.out.print("이름" + "\t");
		for(int i = 0 ; i < numberStudents ; i++ ) {
			System.out.print(students[0].subjects[i] + "\t" +"\t");
		}
		System.out.println("전체 통과여부");
		for(int i = 0 ; i < numberStudents ; i++) {
			System.out.print(students[i].name + "\t");
			for (int j = 0 ; j < students[i].subjects.length ; j++) {
				String pf = (students[i].scores[j] >= students[i].passFails[j]) ? "pass" : "fail";
				System.out.print(students[i].scores[j] + "(" + pf + ")" + "\t");
			}
			System.out.println((students[i].isPassed()? "pass" : "fail"));
		}
		System.out.println("=".repeat(100));
	}
	
	public static void printTable2(Student2[] students) {
		System.out.println("┌────────┬────────┐");
		System.out.println("│" + students[0].subjects[0] + "\t │" + students[0].scores[0] +"\t  │");
		System.out.println("└────────┴────────┘");
	}
	
	
}

public class 실습6_3정적메소드 {
	public static void main(String[] args) {
		String[] subjects = {"수학", "국어", "영어", "과학", "역사"};
		int []passFails = {80,70,60,55,80};
		Student2[] students = { 
				new Student2 ("홍길동", 21, subjects, new int[]{85, 90, 78, 88, 92},passFails, 1),
				new Student2 ("김유신", 22, subjects, new int[]{75, 80, 85, 90, 95}, passFails,1),
				new Student2 ("계백", 23, subjects, new int[]{65, 70, 75, 80, 85}, passFails,1),
				new Student2 ("강감찬", 24, subjects, new int[]{95, 92, 88, 84, 91}, passFails,1),
				new Student2 ("을지문덕", 25, subjects, new int[]{88, 76, 85, 79, 90}, passFails,1)		 
		};
		
		Student2.printAllStudents(students);	
		Student2.printSubjectStats(students);
		Student2.printTable(students);
		Student2.printTable2(students);

		}
}

