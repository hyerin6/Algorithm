package course;

import java.util.Scanner;

// 최대공배수 
public class B1934 {

	static int 최대공약수(int a, int b) {
		int t;
		while(b != 0) {
			t = a%b;
			a = b;
			b = t;
		}
		return a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner scanner = new Scanner(System.in)) {
			int T = scanner.nextInt(); 

			for (int t = 0; t < T; ++t) { 
				int a = scanner.nextInt(); 
				int b = scanner.nextInt(); 
				int 최소공배수 = a * b / 최대공약수(a, b); 
				System.out.println(최소공배수); 
			}
		}
	}
}
