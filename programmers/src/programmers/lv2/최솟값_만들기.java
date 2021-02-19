package programmers.lv2;

import java.util.Arrays;

public class 최솟값_만들기 {

	public static int solution(int[] A, int[] B) {
		int answer = 0;
		
		Arrays.sort(A);
		Arrays.sort(B);

		for (int i = 0; i < A.length; i++) {
			answer = answer + (A[i] * B[A.length - i - 1]);
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 4, 2}, new int[] {5, 4, 4}));
	}

}
