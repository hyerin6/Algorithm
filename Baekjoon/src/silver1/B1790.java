package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1790 {

	// 1부터 n까지 길이 계산
	private static int calc(int n) {
		int count = 0;
		for (int start = 1, digit = 1; start <= n; start *= 10, ++digit) {
			int end = start * 10 - 1;
			if (n < end) {
				end = n;
			}
			count += (end - start + 1) * digit;
		}
		return count;
	}

	// 1부터 n까지 숫자의 합에서 원하는 길이 k값을 만족하는 숫자 반환
	private static int go(int n, int k) {
		int left = 1;
		int right = n;
		int answer = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			int len = calc(mid);
			if (len < k) {
				left = mid + 1;
			} else {
				answer = mid;
				right = mid - 1;
			}
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		// k가 1부터 n까지 범위 밖이라면 -1 출력
		if (calc(n) < k) {
			System.out.println(-1);
			return;
		}

		// 인덱스랑 실제 인덱스로 가져온 값이랑 구분
		int answer = go(n, k);

		int length = calc(answer);
		String ans = answer + "";
		System.out.println(ans.charAt(ans.length() - length + k - 1) + "");
	}
}
