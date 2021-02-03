package bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1100 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String[][] chess = new String[8][8];
		int whiteCnt = 0;

		for (int i = 0; i < 8; ++i) {
			chess[i] = br.readLine().split("");
		}

		for (int i = 0; i < 8; ++i) {
			for (int j = 0; j < 8; ++j) {
				if (chess[i][j].equals("F")) {
					if (i % 2 == 0 && j % 2 == 0) {
						whiteCnt++;
					} else if (i % 2 == 1 && j % 2 == 1) {
						whiteCnt++;
					}
				}
			}
		}

		System.out.println(whiteCnt);
	}
}
