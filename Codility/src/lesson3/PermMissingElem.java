package lesson3;

import java.util.Arrays;

public class PermMissingElem {
	static class Solution {
		public static int solution(int[] A) {
			Arrays.sort(A);
			for (int i = 0; i < A.length; ++i) {
				if (A[i] != i + 1) {
					return i + 1;
				}
			}
			return A.length + 1;
		}
	}

	public static void main(String[] args) {
		int answer = Solution.solution(new int[] {2, 3, 1, 5});
		System.out.println(answer);
	}
}
