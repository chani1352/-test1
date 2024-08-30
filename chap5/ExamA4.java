package chap5;

class Student {
	
	public Student(String name, String[] subjects, int[] criteria, int[] scores) {
		this.name = name;
		this.criteria = criteria;
		this.subjects = subjects;
		this.scores = scores;	
	}
	
	private String name;
	private int[] scores;
	private int sum;
	private int avg;
	private String[] subjects;
	private int[] criteria;
	private String[] passed = new String[5];
	public static int max[] = {0,0,0,0,0};
	public static String maxName[] = new String[5];
	public static int min[] = {100,100,100,100,100};
	public static String minName[] = new String[5];

	public void sumScore() {
		for (int i = 0 ; i < 5 ; i++) {
			sum += scores[i];
		}
	}
	
	public void average() {
		avg = sum/5;
	}
	
	public void isPassed() {
		for(int i = 0 ; i < 5 ; i++) {
			if(criteria[i] > scores[i] ) { 
				passed[i] = "(과락)";
			}else {
				passed[i] = "";
			}
		}	
	}
	
	public void maxScore() {
		for(int i = 0 ; i < 5 ; i++) {
			if ( scores[i] > max[i]) {
				max[i] = scores[i];
				maxName[i] = name;
			}
		}
	}
	
	
	public void minScore() {
		for(int i = 0 ; i < 5 ; i++) {
			if ( scores[i] < min[i]) {
				min[i] = scores[i];
				minName[i] = name;
			}
		}
	}

	public void scoreTable() {
		System.out.print(name + "\t" + sum + "\t" + avg);
		for (int i = 0 ; i < 5 ; i++) {
			System.out.print("\t" + scores[i] + passed[i]);
		}
		System.out.println();
	}
	
	public void maxMinTable() {
		for(int i = 0 ; i < 5 ; i++) {
			System.out.println(subjects[i] + " \t" + max[i] + "\t" + min[i] + "\t" + maxName[i] + "\t" + minName[i]);
		}
	}
	
		
}
	

public class ExamA4 {

	public static void main(String[] args) {
		String[] subjects = {"수학","국어","영어","과학","역사"};
		int[] criteria = { 50, 60, 70, 80, 90 };
		Student[] students = {new Student("홍길동", subjects, criteria,new int[]{85, 90, 78, 88, 92}), 
							  new Student("김유신", subjects, criteria,new int[]{75, 80, 85, 90, 95}), 
							  new Student("계백", subjects, criteria,new int[]{65, 70, 75, 80, 85}), 
							  new Student("강감찬", subjects, criteria,new int[]{95, 92, 88, 84, 91}), 
							  new Student("을지문덕", subjects, criteria,new int[]{88, 76, 85, 79, 90})};
		
		
		System.out.println(">>>각 학생의 성적 테이블 출력");
		System.out.println("=========================================================================================================");
		System.out.println("이름" + "\t" + "총점" + "\t" + "평균" +"\t" + "수학" + "\t" + "국어" + "\t" +"영어" + "\t" + "과학" + "\t" + "역사");
		System.out.println("---------------------------------------------------------------------------------------------------------");
		
		for (int i = 0 ; i < 5 ; i++) {
			students[i].sumScore();
			students[i].average();
			students[i].isPassed();
			students[i].scoreTable();
		}
		
		System.out.println("=========================================================================================================");
		System.out.println(">>>과목별 최대/최소 점수 및 해당 학생 이름 출력");
		System.out.println("=====================================================================================");
		System.out.println("과목" + "\t" + "최고점" + "\t" + "최저점" +"\t" + "최고점학생" + "\t" + "최저점학생");
		System.out.println("-------------------------------------------------------------------------------------");
		
		for (int i = 0 ; i < 5 ; i++) {
			students[i].maxScore();
			students[i].minScore();
		}
		students[4].maxMinTable();
	}

}