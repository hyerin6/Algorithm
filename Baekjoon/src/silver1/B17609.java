package silver1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B17609 {

	private static int solution(String str, int left, int right, int cnt) {
		if (cnt == 2) {
			return 2;
		}

		int ret = cnt;
		while (left < right) {
			// 다른 문자가 나오면 유사회문인지 확인 필요
			if (str.charAt(left) != str.charAt(right)) {
				// 왼쪽이나 오른쪽을 삭제해본다. (재귀)
				int leftValue = solution(str, left + 1, right, cnt + 1);
				int rightValue = solution(str, left, right - 1, cnt + 1);
				ret = Math.min(leftValue, rightValue);
				break;
			}
			// 문자가 같으면 계속 비교
			left++;
			right--;
		}

		return ret;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; ++i) {
			String str = br.readLine();
			int answer = solution(str, 0, str.length() - 1, 0);
			bw.write(answer + "\n");
		}
		bw.close();
		br.close();
	}
}
