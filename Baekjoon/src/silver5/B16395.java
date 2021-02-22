package silver5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B16395 {

	static int[][] pascal = new int[31][31];

	private static void makePascal() {
		pascal[1][1] = 1;
		for (int i = 1; i < pascal.length; ++i) {
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

		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());

		makePascal();
		bw.write(pascal[n1][n2] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
