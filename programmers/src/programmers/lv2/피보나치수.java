package programmers.lv2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class 피보나치수 {

	public static int solution(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}

		int pre1 = 1;
		int pre2 = 1;
		int answer = 0;

		for (int i = 3; i <= n; i++) {
			answer = (pre1 + pre2) % 1234567;
			pre1 = pre2;
			pre2 = answer;
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(solution(5) + "\n");
		bw.flush();
		bw.close();
	}
}
