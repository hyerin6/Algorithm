package bronze3;

import java.util.Scanner;

// N을 입력받은 뒤, 구구단 N단을 출력

public class B2739 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		if (n > 0 || n < 10) {
			for (int i = 1; i < 10; ++i)
				System.out.printf("%d * %d = %d\n", n, i, n * i);
		}

	}

}
