package silver2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B5525 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		char[] s = br.readLine().toCharArray();

		int result = 0;
		int patternCnt = 0;
		for (int i = 1; i < M - 1; i++) {
			if (s[i - 1] == 'I' && s[i] == 'O' && s[i + 1] == 'I') {
				patternCnt++;
				if (patternCnt == N) {
					patternCnt--;
					result++;
				}
				i++;
			} else
				patternCnt = 0;
		}

		System.out.println(result);
	}
}
