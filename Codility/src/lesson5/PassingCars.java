package lesson5;

public class PassingCars {

	private static final int MAX = 1000000000;

	public static int solution(int[] A) {
		int zero = 0;
		int pairs = 0;

		for (int a : A) {
			if (a == 0) {
				zero++;
				continue;
			}
			pairs += zero;
			if (pairs > MAX) {
				return -1;
			}
		}

		return pairs;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] {0, 1, 0, 1, 1}));
	}
}
