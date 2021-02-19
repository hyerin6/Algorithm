package programmers.lv2;

import java.util.TreeSet;

public class N으로표현 {

	static int _N;
	static TreeSet<Integer>[] dp;

	// N, NN, NNN, ... , NNNNNNNN과 사칙 연산 +, - *, /를 이용한 경우의 수 중에 가장 N을 적게 사용한 경우
	public static TreeSet<Integer> solve(int n) {
		if ((dp[n] != null) && !dp[n].isEmpty()) {
			return dp[n]; //전에 있던 집합 찾기.
		}

		// n이 2이면 NN, N이 0이면 0
		int num = 0;
		for (int i = 0; i < n; i++) {
			num = 10 * num + _N;
		}

		TreeSet<Integer> temp = new TreeSet<>();
		temp.add(num);

		/*
		dynamic[j] = dynamic[n-i]는 만약 n이 6이고 i가 2였다면, dynamic[i]는 NN을 의미(N을 2번 사용하여 나온 결과)
		dynamic[N-i]는 NNNN의미 (N을 4번 사용하여 나온 결과 의미)
		만약 NNNN의 결과를 구한다면, N + NNN / NN + NN / N + NNN 이 세 가지를 통해 구하는 것을 의미한다.
		i는 즉 N을 몇번 활용했는가를 의미한다.
		또한, dp는 결과를 저장하는 집합의 배열이고, dp내부의 temp는 집합이 저장됨을 헷갈리면 안된다.
		 */
		for (int i = 1; i < n; i++) {
			int j = n - i;
			TreeSet<Integer> from = solve(i);
			TreeSet<Integer> to = solve(j);

			for (int n1 : from) {
				for (int n2 : to) { //d[n] = d[n-i] + d[i];
					temp.add(n1 + n2);
					temp.add(n1 - n2);
					temp.add(n1 * n2);
					if (n2 != 0) {
						temp.add(n1 / n2);
					}
				}
			}
		}
		return dp[n] = temp;
	}

	public static int solution(int N, int number) {
		int answer = 0;
		_N = N;

		dp = new TreeSet[10];
		for (int i = 1; i <= 8; i++) {
			solve(i);
			if (dp[i].contains(number)) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(solution(5, 12));
		System.out.println(solution(2, 11));
	}
}
