package training;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class B1268 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][5];
		int max = 0;
		int answer = 0;

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; ++i) {
			Set<Integer> sameClass = new HashSet<>();
			for (int j = 0; j < 5; ++j) {
				for (int l = 0; l < N; ++l) {
					if (arr[i][j] == arr[l][j] && l != i) {
						sameClass.add(l);
					}
				}
			}
			if (max < sameClass.size()) {
				max = sameClass.size();
				answer = i;
			}
		}

		bw.write((answer + 1) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
