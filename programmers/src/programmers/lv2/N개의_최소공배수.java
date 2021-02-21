package programmers.lv2;

public class N개의_최소공배수 {

	public static int solution(int[] arr) {
		// 연속된 최소공배수를 구하기 위해서 비교하기 위한 최소한 하나의 값이 필요하므로 그 값을 배열의 첫 번째 요소로 정한다.
		int lcm = arr[0];

		for (int i = 1; i < arr.length; i++) {
			lcm = lcm(lcm, arr[i]);
		}

		return lcm;
	}

	// 최대공약수
	public static int gcd(int a, int b) {
		while (b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}

	// 최소공배수 = 두수의 곱 / 두수의 최대공약수
	public static int lcm(int a, int b) {
		if (a <= 0 || b <= 0) {
			return -1;
		}
		return a * b / gcd(a, b);
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] {2, 6, 8, 14}));
		System.out.println(solution(new int[] {1, 2, 3}));
	}
}
