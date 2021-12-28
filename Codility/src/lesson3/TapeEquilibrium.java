package lesson3;

public class TapeEquilibrium {

	public static int solution(int[] A) {
		int firstSum = 0;
		int secondSum = 0;
		int minDiff = Integer.MAX_VALUE;

		for (int i = 0; i < A.length; i++) {
			secondSum += A[i];
		}

		for (int p = 1; p < A.length; p++) {
			firstSum += A[p - 1];
			secondSum -= A[p - 1];

			int diff = Math.abs(firstSum - secondSum);
			if (diff < minDiff) {
				minDiff = diff;
			}
		}

		return minDiff;
	}

	public static void main(String[] args) {
		int answer = solution(new int[] {3, 1, 2, 4, 3});
		System.out.println(answer);
	}
}
