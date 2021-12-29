package lesson4;

import java.util.HashSet;
import java.util.Set;

public class MissingInteger {

	public static int solution(int[] A) {
		Set<Integer> nums = new HashSet<>();

		for (int a : A) {
			nums.add(a);
		}

		for (int i = 1; i <= Integer.MAX_VALUE; ++i) {
			if (!nums.contains(i)) {
				return i;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int answer = solution(new int[] {-1, -3});
		System.out.println(answer);
	}
}
