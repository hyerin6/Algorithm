package silver2;

import java.util.Scanner;

// 
public class B1890 {
	/* 경로의 개수는 263-1보다 작거나 같다. = Long Integer로 구현하라.
	 *
	 * 다음단계:
	 * 경로수(행 + 칸[행][열], 열)
	 * 경로수(행, 열 + 칸[행][열])
	 *
	 * 현재단계:
	 * int 경로수1 = 경로수(행 + 칸[행][열], 열)
	 * int 경로수2 = 경로수(행, 열 + 칸[행][열])
	 * return 경로수1 + 경로수2;
	 *
	 * 종료조건:
	 * if(행 == 행수 - 1 && 열 == 열수 - 1) return 0;
	 * int 경로수1 = 0, 경로수2 = 0;
	 * if(행 + 칸[행][열] < 행수) 경로수1 = 경로수(행 + 칸[행][열], 열)
	 * if(열 + 칸[행][열] < 열수) 경로수2 = 경로수(행, 열 + 칸[행][열])
	 * return 경로수1 + 경로수2;
	 */
	static int game(int[][] arr, int i, int j) {
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[][] arr = new int[n][n];

		for (int i = 0; i < n; ++i)
			for (int j = 0; j < n; ++j)
				arr[i][j] = scan.nextInt();
	}

}
