package lesson4;

import java.util.Arrays;

public class MaxCounters {

	public static int[] solution(int N, int[] A) {
		int max = 0;
		int temp = 0;
		int[] answer = new int[N];

		for (int i = 0; i < A.length; ++i) {
			if (A[i] > N) {
				max = temp;
				continue;
			}
			if (answer[A[i] - 1] < max) {
				answer[A[i] - 1] = max;
			}
			answer[A[i] - 1]++;
			if (answer[A[i] - 1] > temp) {
				temp = answer[A[i] - 1];
			}
		}

		for (int i = 0; i < N; ++i) {
			if (answer[i] < max) {
				answer[i] = max;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		int[] answer = solution(5, new int[] {3, 4, 4, 6, 1, 4, 4});
		System.out.println(Arrays.toString(answer));
	}

}
