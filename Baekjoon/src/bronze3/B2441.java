package bronze3;

import java.util.Scanner;

// 첫째 줄에는 별 N개, 둘째 줄에는 별 N-1개.. N번째 줄에는 별  1개

public class B2441 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		if (1 <= n || n <= 100) {
			for (int i = n; i > 0; --i) {
				for (int j = 0; j < n; ++j) {
					if (j < n - i)
						System.out.print(" ");
					else
						System.out.print("*");
				}
				System.out.println();
			}
		}

	}

}
