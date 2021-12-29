package lesson4;

import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne {

	public static int solution(int X, int[] A) {
		Set<Integer> marks = new HashSet<>();

		for (int i = 0; i < A.length; ++i) {
			if (A[i] <= X) {
				marks.add(A[i]);
				if (marks.size() == X) {
					return i;
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		System.out.println(solution(5, new int[] {1, 3, 1, 4, 2, 3, 5, 4}));
	}

}
