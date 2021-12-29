package lesson4;

import java.util.HashSet;
import java.util.Set;

public class PermCheck {
	public static int solution(int[] A) {
		Set<Integer> marks = new HashSet<>();

		for (int i = 0; i < A.length; ++i) {
			if (A[i] > A.length) {
				return 0;
			}
			if (marks.contains(A[i])) {
				return 0;
			}
			marks.add(A[i]);
		}
		return 1;
	}

	public static void main(String[] args) {
		int answer = solution(new int[] {1, 4, 3, 2});
		System.out.println(answer);
	}
}
