package silver5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B15489 {

	static int[][] pascal = new int[30][30];

	private static void makePascal() {
		pascal[1][1] = 1;
		for (int i = 1; i < 30; ++i) {
			for (int j = 1; j <= i; ++j) {
				if (j == 1 || j == i)
					pascal[i][j] = 1;
				else
					pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int ans = 0;

		makePascal();

		for (int i = 0; i < W; i++) {
			for (int j = 0; j <= i; j++) {
				ans += pascal[R + i][C + j];
			}
		}

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
