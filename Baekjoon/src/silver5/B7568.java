package silver5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B7568 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][2];

		String[] str;
		for (int i = 0; i < N; ++i) {
			str = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(str[0]);    // [i][0] : 몸무게 
			arr[i][1] = Integer.parseInt(str[1]);    // [i][1] : 키 
		}

		for (int i = 0; i < N; ++i) {
			int rank = 1; // 1부터 시작

			for (int j = 0; j < N; ++j) {
				if (i == j) {
					continue;
				} else if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					rank++;
				}
			}
			sb.append(rank).append(' ');
		}

		bw.write(sb + "\n");
		bw.close();
		br.close();
	}
}
