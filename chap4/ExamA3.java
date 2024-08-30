package chap4;


public class ExamA3 {

	public static void main(String[] args) {
		String[] names = {"홍길동", "김유신", "계백", "강감찬", "을지문덕"};
		String[] subjs = {"수학", "국어", "영어", "과학", "역사"};
		int[] criteria = {50,60,70,80,80};
		int[][] scores = {{85, 90, 78, 88, 92}, {75, 80, 85, 90, 95}, {65, 70, 75, 80, 85}, {95, 92, 88, 84, 91}, {88, 76, 85, 79, 90}};
		String result ; 
		int sum = 0;
		int[] subsum = new int[subjs.length];
		int max = 0;
		int min = 100;
		String maxName = null;
		String minName = null;

		
		System.out.println(">>>학생별, 과목별 점수, 통과여부 출력");
		System.out.println("==============================");
		
		for(int i = 0 ; i < names.length ; i++) {
			System.out.println("["+ names[i] + "]");
			for(int j = 0 ; j < subjs.length ; j++) {
				if (scores[i][j] >= criteria[j]) {
					result = "통과";
				}else {
					result = "과락";
				}
				System.out.println("\t" + subjs[j] + ":" + scores[i][j] + "=>" + result);
				sum += scores[i][j];
			}
			System.out.println("\t" + "총점:" + sum);
			System.out.println("\t" + "평균:" + ((double)sum/scores[i].length));
			sum = 0;
			
		} 
		System.out.println("\n"+"\n");
		System.out.println(">>>과목 총점 및 평균 점수를 테이블로 출력");
		System.out.println("==============================================");
		System.out.print("이름" + "\t");
		
		for(int i = 0 ; i < subjs.length ; i++) {
			System.out.print(subjs[i] + "\t");
		}
		System.out.println();
		System.out.println("----------------------------------------------");
			
		for(int i = 0 ; i < names.length ; i++) {
			System.out.print(names[i] + "\t");
			for(int j = 0 ; j < scores[i].length ; j++) {
			System.out.print(scores[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.print("총점"+"\t");
		for (int i = 0 ; i < scores.length ; i++) {
			for(int j = 0 ; j < scores[i].length ; j++) {
				sum += scores[j][i];
				subsum[i] = sum;
			}
			System.out.print(sum + "\t");		
			sum = 0;
		}
		System.out.println();
		System.out.print("평균"+"\t");
		for(int i = 0 ; i < subsum.length ; i++) {
			System.out.print((double)subsum[i]/subsum.length +"\t");
		}
		
		System.out.println();
		System.out.println("========================================================");
		System.out.println(">>>과목별 최대, 최소 점수를 구하고, 해당 점수의 학생 이름을 테이블로 출력");
		System.out.println("========================================================");
		System.out.println("==과목별 최대 점수==");
		System.out.println("과목" + "\t" + "점수" + "\t" + "이름");
		System.out.println("---------------------------------");
		for(int i = 0 ; i < subjs.length ; i++) {
			System.out.print(subjs[i] + "\t");
			for(int j = 0 ; j < scores[i].length ; j++) {
					if (max < scores[j][i]) {
						max = scores[j][i];
						maxName = names[j];
					}
			}
			System.out.print(max + "\t");
			max = 0;
			System.out.println(maxName);

		}
		
		System.out.println("==과목별 최소 점수==");
		System.out.println("과목" + "\t" + "점수" + "\t" + "이름");
		System.out.println("---------------------------------");
		for(int i = 0 ; i < subjs.length ; i++) {
			System.out.print(subjs[i] + "\t");
			for(int j = 0 ; j < scores[i].length ; j++) {
					if (min > scores[j][i]) {
						min = scores[j][i];
						minName = names[j];
					}
			}
			System.out.print(min + "\t");
			min = 100;
			System.out.println(minName);

		}
	}
}
		
	
	

