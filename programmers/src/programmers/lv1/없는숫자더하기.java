package programmers.lv1;

public class 없는숫자더하기 {

	public static int solution(int[] numbers) {
		int answer = 0;
		boolean[] isMatch = new boolean[10];

		for (int n : numbers) {
			isMatch[n] = true;
		}

		for (int i = 0; i < 10; ++i) {
			if (!isMatch[i]) {
				answer += i;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		int result = solution(new int[] {1, 2, 3, 4, 6, 7, 8, 0});
		System.out.println(result);
	}
}
