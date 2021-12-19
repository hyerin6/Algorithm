package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15486 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] T = new int[N + 2]; // 상담을 완료하는 데 걸리는 기간
		int[] P = new int[N + 2]; // 상담했을 때 받을 수 있는 금액
		int[] dp = new int[N + 2]; // 최대 금액을 기록하기 위한 dp
		int max = 0;

		for (int i = 1; i <= N; ++i) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		// i는 상담 시작 날짜
		for (int i = 1; i < N + 2; ++i) {
			if (max < dp[i]) {
				max = dp[i];
			}
			int day = i + T[i]; // 종료 날짜 계산
			if (day < N + 2) { // 퇴사 전에 할 수 있는 상담인 경우
				dp[day] = Math.max(dp[day], max + P[i]);
			}
		}

		System.out.println(max);

	}
}
