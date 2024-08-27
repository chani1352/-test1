package chap3_제어문;

public class Test30_1 {

	public static void main(String[] args) {
		int j = 0;
		for (int i = 1; i <= 100; i++) {
			if ((i % 2) == 0 && (i % 3) == 0) {
				System.out.println(i + "은 2와 3의 배수입니다.");
				j++;
			}
		}
		System.out.println("2와 3의 배수의 개수는 " + j);
	}
}
