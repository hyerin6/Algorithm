package gold5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B17425 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		long fx[] = new long[1000001]; // 해당 자연수의 모든 약수를 더한 변수.
		long dp[] = new long[1000001]; // 해당 자연수 이하의 모든 fx값을 더한 변수.
		Arrays.fill(fx, 1);       // 1은 모든 수의 약수니까 전부 넣어준다.

		/*
		2부터 i를 약수로 갖는 수에 (i의 배수들에) i를 더한다.
		시간복잡도는 NlgN이다.
		j는 i*j까지만 반복한다.
		예를 들어 i가 2일 경우 j는 50만까지만 가면된다.
		2 * 50만 = 100만
		*/
		for (int i = 2; i < fx.length; i++) {
			for (int j = 1; i * j < fx.length; j++) {
				fx[i * j] += i;
			}
		}

		// g(x), x보다 작거나 같은 모든 자연수y의 f(y)값을 더한 변수.
		for (int i = 1; i < dp.length; i++) {
			dp[i] += dp[i - 1] + fx[i];
		}

		// 테스트 케이스에 따라서 답만 도출한다.
		while (T-- > 0) {
			int input = Integer.parseInt(br.readLine());
			sb.append(dp[input]).append("\n");
		}

		System.out.println(sb);

	}

}
