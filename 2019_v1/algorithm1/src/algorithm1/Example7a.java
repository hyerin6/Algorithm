package algorithm1;

import java.util.Scanner;

public class Example7a {

	static void print1(int n) {
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j <= i; ++j)
				System.out.print("*");
			System.out.println();
		}
	}

	static void print2(int n, int i, int j) {
		if(i >= n) return;
		System.out.printf("*");
		if(j < i) print2(n, i, j+1);
		else {
			System.out.println();
			print2(n, i+1, 0);
		}
	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("행 수를 입력하시오: ");
			int n = scanner.nextInt();
			print1(n);
			System.out.println();
			print2(n, 0, 0);
		}
	}
}
