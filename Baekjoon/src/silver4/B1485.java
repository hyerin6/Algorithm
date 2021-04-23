package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B1485 {

	static int isSquare(int[][] input) {

		// x 좌표 우선 정렬
		Arrays.sort(input, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				} else {
					return o1[0] - o2[0];
				}
			}
		});

		// 네 변의 길이
		int d1 = (int)(Math.pow(input[1][0] - input[0][0], 2) + Math.pow(input[1][1] - input[0][1], 2));
		int d2 = (int)(Math.pow(input[3][0] - input[1][0], 2) + Math.pow(input[3][1] - input[1][1], 2));
		int d3 = (int)(Math.pow(input[3][0] - input[2][0], 2) + Math.pow(input[3][1] - input[2][1], 2));
		int d4 = (int)(Math.pow(input[2][0] - input[0][0], 2) + Math.pow(input[2][1] - input[0][1], 2));
		// 대각선 길이
		int d5 = (int)(Math.pow(input[0][0] - input[3][0], 2) + Math.pow(input[0][1] - input[3][1], 2));
		int d6 = (int)(Math.pow(input[1][0] - input[2][0], 2) + Math.pow(input[1][1] - input[2][1], 2));

		if (d1 == d2 && d2 == d3 && d3 == d4 && d5 == d6) {
			return 1;
		}
		return 0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; ++i) {
			int[][] input = new int[4][4];
			for (int j = 0; j < 4; ++j) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				input[j][0] = Integer.parseInt(st.nextToken());
				input[j][1] = Integer.parseInt(st.nextToken());
			}
			int result = isSquare(input);
			System.out.println(result);
		}
	}
}
