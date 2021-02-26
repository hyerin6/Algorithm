package bronze2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B1668 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] height = new int[N];

		for (int i = 0; i < N; ++i) {
			height[i] = Integer.parseInt(br.readLine());
		}

		int max = height[0];
		int cnt = 1;

		for (int i = 1; i < N; ++i) {
			// height[i](뒤에 있는 트로피)의 길이가 더 길어야 보인다.
			if (height[i] > max) {
				cnt++;
				max = height[i];
			}
		}
		bw.write(cnt + "\n");

		max = height[N - 1];
		cnt = 1;

		for (int i = N - 2; i >= 0; --i) {
			if (height[i] > max) {
				cnt++;
				max = height[i];
			}
		}
		bw.write(cnt + "\n");

		bw.flush();
		bw.close();
		br.close();
	}

}
