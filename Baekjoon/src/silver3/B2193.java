package silver3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
N의 범위가 90까지 주어졌기 때문에 int 범위를 넘어가 버린다. 메모이제이션으로 활용할 배열을 long 타입으로 선언해야 한다
또한, 이 문제는 조금만 예제를 만들어보면 피보나치 규칙을 갖고 있음을 알 수 있지만
마지막 숫자가 0일 때는 다음 자릿수에 0, 1이 올 수 있고 1일 때는 0만 올 수 있다는 개념을 갖고 풀어도 좋다.
solution 메서드에서는 위 개념의 풀이이다.
*/
public class B2193 {

	public static void solution(int N) {
		long[][] dp = new long[N + 1][2];
		dp[1][0] = 0; // 한자리 수 인데 0이 되는건 불가능
		dp[1][1] = 1; // 한자리 수는 1이 될 수 있다.

		for (int i = 2; i <= N; ++i) {
			dp[i][0] = dp[i - 1][0] + dp[i - 1][1]; // 끝자리가 0이 되려면 이전에 0이거나 1이거나 상관없음
			dp[i][1] = dp[i - 1][0]; // 끝자리가 1이 되려면 이전에 무조건 0이 되어야함
		}

		System.out.println(dp[N][0] + dp[N][1]);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		long[] dp = new long[91];
		dp[1] = 1;
		dp[2] = 1;

		for (int i = 3; i <= N; ++i) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		System.out.println(dp[N]);
		solution(N);
	}
}
