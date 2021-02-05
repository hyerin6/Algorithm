package bronze1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B1236 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		String[][] arr = new String[r][c];
		int row = 0;
		int col = 0;

		for (int i = 0; i < r; ++i) {
			String str = br.readLine();
			for (int j = 0; j < c; ++j) {
				arr[i][j] = String.valueOf(str.charAt(j));
			}
		}

		for (int i = 0; i < r; ++i) {
			boolean flag = true;
			for (int j = 0; j < c; ++j) {
				if ("X".equals(arr[i][j])) {
					flag = false;
					break;
				}
			}
			if (flag) {
				row++;
			}
		}

		for (int i = 0; i < c; ++i) {
			boolean flag = true;
			for (int j = 0; j < r; ++j) {
				if ("X".equals(arr[j][i])) {
					flag = false;
					break;
				}
			}
			if (flag) {
				col++;
			}
		}

		bw.write(Math.max(row, col) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
