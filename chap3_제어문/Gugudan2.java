package chap3_제어문;

import java.util.Scanner;

public class Gugudan2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int key = sc.nextInt();
		int k = 2;
		for(int num = key ; num < 20 ; num +=key) {
			for(int i = 1 ; i < 10 ; i++) {
				for(int j = k ; j < 10 ; j++) {
					if( j > num+1) break;
					System.out.print(j + "*" + i + "=" + (j*i) + "\t");
				}
				System.out.println();
			}
			System.out.println();
			k = k + key;
		}
		sc.close();

	}


}