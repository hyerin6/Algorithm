package training;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B1233 {

	static int[] s1;
	static int[] s2;
	static int[] s3;

	private static int[] makeDice(int n) {
		int[] answer = new int[n];

		for (int i = 1; i <= n; ++i) {
			answer[i - 1] = i;
		}

		return answer;
	}

	private static int findMax() {
		int cnt[] = new int[81];
		int answer = 0;

		for (int i = 0; i < s1.length; ++i) {
			for (int j = 0; j < s2.length; ++j) {
				for (int k = 0; k < s3.length; ++k) {
					cnt[s1[i] + s2[j] + s3[k]]++;
				}
			}
		}

		int key = 0;
		for (int i = 0; i < cnt.length; ++i) {
			key = Math.max(key, cnt[i]);
		}

		for (int i = 0; i < cnt.length; ++i) {
			if (key == cnt[i]) {
				answer = i;
				break;
			}
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());
		int n3 = Integer.parseInt(st.nextToken());

		s1 = makeDice(n1);
		s2 = makeDice(n2);
		s3 = makeDice(n3);

		bw.write(findMax() + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
