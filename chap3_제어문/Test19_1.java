package chap3_제어문;

import java.util.Scanner; //ctrl shift o

public class Test19_1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Score : ");
		int score = sc.nextInt();

		System.out.println(score >= 60 ? "합격" : "불합격");
		
		sc.close();
	}

}
