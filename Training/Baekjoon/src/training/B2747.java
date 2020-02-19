package training;

import java.util.Scanner;

public class B2747 { // 백준 2747 - 10870과 마찬가지로 '피보나치 수 구하기'지만 재귀호출로 구현하면 안된다.

	static int[] a = new int[100];

	static int fibonacci(int n) {
		// a[0] 은 배열 선언하면서 0으로 초기화 되었다. 
		a[1] = a[2] = 1;
		for (int i = 3; i <= n; ++i)
			a[i] = a[i - 1] + a[i - 2];
		return a[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		System.out.println(fibonacci(n));
	}
}
