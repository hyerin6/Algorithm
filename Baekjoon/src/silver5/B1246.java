package silver5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1246 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] p = new int[M];

		for (int i = 0; i < M; ++i) {
			p[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(p);

		int result = 0;
		int price = 0;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < M; ++i) {
			if (M - i <= N) { // p[i] 가격에 살 수 있는 사람 <= 판매 가능한 달걀 수
				result = p[i] * (M - i); // p[i] 가격 * 살 수 있는 사람
			} else {
				result = p[i] * N; // p[i] * 판매 가능한 달걀 수
			}
			if (max < result) {
				price = p[i];
				max = result;
			}
		}

		bw.write(price + " " + max);
		bw.flush();
		bw.close();
		br.close();
	}
}
