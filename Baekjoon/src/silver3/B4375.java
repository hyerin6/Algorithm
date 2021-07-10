package silver3;

import java.io.IOException;
import java.util.Scanner;

public class B4375 {

	public static void printSolution(int n) {
		int num = 0;
		for (int i = 1; ; ++i) {
			num = num * 10 + 1; // 1, 11, 111 ... 1로만 이뤄진 수를 구한다.
			num = num % n; // n의 배수인지 확인하기 위해 나머지를 구한다.
			if (num == 0) {
				System.out.println(i);
				return;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNextInt()) {
			int n = sc.nextInt();
			printSolution(n);
		}
	}
}
