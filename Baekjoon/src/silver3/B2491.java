package silver3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B2491 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int cnt = 1;
		int max = 1;
		for (int i = 0; i < N - 1; ++i) {
			if (arr[i] <= arr[i + 1]) {
				cnt++;
			} else {
				cnt = 1;
			}
			max = Math.max(cnt, max);
		}

		cnt = 1;
		for (int i = 0; i < N - 1; ++i) {
			if (arr[i] >= arr[i + 1]) {
				cnt++;
				max = Math.max(cnt, max);
			} else {
				cnt = 1;
			}
			max = Math.max(cnt, max);
		}

		bw.write(max + "\n");
		bw.close();
	}
}
