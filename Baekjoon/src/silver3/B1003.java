package silver3;

import java.util.Scanner;

// 1003 피보나치 함수
public class B1003 {

	static void count(int n) {
		int[] a1 = new int[Math.max(2, n + 1)];
		int[] a2 = new int[Math.max(2, n + 1)];
		a1[0] = 1;
		a1[1] = 0;
		a2[0] = 0;
		a2[1] = 1;

		for (int i = 2; i <= n; ++i) {
			a1[i] = a1[i - 1] + a1[i - 2];
			a2[i] = a2[i - 1] + a2[i - 2];
		}
		System.out.println(a1[n] + " " + a2[n]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		for (int i = 0; i < n; ++i) {
			int n2 = scanner.nextInt();
			count(n2);
		}

	}

}
