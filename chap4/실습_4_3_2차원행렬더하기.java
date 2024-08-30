package chap4;

public class 실습_4_3_2차원행렬더하기 {
	public static void main(String[] args) {
		
		int a[][] = new int[5][7];
		int b[][] = new int[5][7];		
		int c[][] = new int[5][7];
		
		int num = 1;
		System.out.println("A = ");
		for(int i = 0 ; i < a.length ; i++) {
			System.out.print("\t");
			for(int j = 0 ; j < a[i].length ; j++) {
				a[i][j] = num;
				System.out.print(a[i][j]);
				if(j == a[i].length-1) break;
				System.out.print(",");
				num++;
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("B = ");
		
		for(int i = 0 ; i < b.length ; i++) {
			System.out.print("\t");
			for(int j = 0 ; j < b[i].length ; j++) {
				b[i][j] = num;
				System.out.print(b[i][j]);
				if(j == b[i].length-1) break;
				System.out.print(",");
				num++;
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("C = ");
		
		for (int i = 0 ; i < c.length ; i++) {
			System.out.print("\t");
			for(int j = 0 ; j < c[i].length ; j++) {
				c[i][j] = a[i][j] + b[i][j];
				System.out.print(c[i][j]);
				if(j == c[i].length-1) break;
				System.out.print(",");
			}
			System.out.println();
		}
		
		
		
		
        // 두 개의 2차원 배열 생성 및 초기화
		/*
		 * 행렬 [5][7] A, B를 정수로 선언하고 12개의 값을 초기화
		 */


        // 결과를 저장할 2차원 배열
		/*
		 * C = A + B => 행렬 A와 B를 더하여 C에 넣기 위한 정수 배열 C를 선언
		 */

        // 행렬 더하기
		/*
		 * A, B를 더한 결과를 저장하는 C를 구하는 for 문 구현
		 */


        // 결과 출력
		/*
		 * 행렬 A, B, C를 출력하는 코드 작성
		 * 출력 형태는 
		 * "A = 
		 *      1,2,3,4,5,6,7
		 *      8,9, ...
		 *  B = 
		 *  
		 *  C = 
		 */
    }
}
