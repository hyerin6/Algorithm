package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class B11650 {

	public static void solution(int[][] arr) {

		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] x, int[] y) {
				// x좌표의 값이 동일한 경우, y좌표의 값으로 정렬한다.
				if (x[0] == y[0]) {
					return Integer.compare(x[1], y[1]);
				}
				return Integer.compare(x[0], y[0]);
			}

		});

		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i][0] + " " + arr[i][1]);

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());
		int[][] arr = new int[N][2];
		String[] str = new String[2];

		for (int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(str[0]);
			arr[i][1] = Integer.parseInt(str[1]);
		}

		solution(arr);
	}

}
