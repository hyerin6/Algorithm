package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1449
public class B1449 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		double[] point = new double[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			point[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(point);

		double pre = point[0] - 0.5 + L;
		int cnt = 1;
		for (int i = 1; i < N; ++i) {
			if (pre >= point[i] + 0.5) {
				continue;
			} else {
				cnt++;
				pre = point[i] - 0.5 + L;
			}
		}

		System.out.println(cnt);
	}

}
