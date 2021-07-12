package programmers.lv1;

public class 약수의_개수와_덧셈 {

	public static int solution(int left, int right) {
		int answer = 0;

		for (int i = left; i <= right; ++i) {
			int cnt = 0;
			for (int j = 1; j <= Math.sqrt(i); ++j) {
				if (j * j == i) {
					cnt++;
				}
			}

			answer = cnt % 2 == 0 ? answer + i : answer - i;
		}

		return answer;
	}

	public static void main(String[] args) {
		int result1 = solution(13, 17);
		int result2 = solution(24, 27);

		System.out.println(result1);
		System.out.println(result2);
	}
}
