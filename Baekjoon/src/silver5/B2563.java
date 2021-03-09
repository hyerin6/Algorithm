package silver5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B2563 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int[][] map = new int[101][101];
		int result = 0;

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());

			for (int l = x; l < x + 10; ++l) {
				for (int j = y; j < y + 10; ++j) {
					if (map[l][j] == 0) {
						map[l][j] = 1;
						result++;
					}
				}
			}
		}

		bw.write(result + "\n");
		bw.close();
		br.close();

	}
}