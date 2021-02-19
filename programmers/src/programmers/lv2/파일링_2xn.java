package programmers.lv2;

public class 파일링_2xn {

	public static int solution(int n) {
		int answer = 0;
		int[] arr = new int[n];
		arr[0] = 1;
		arr[1] = 2;

		for (int i = 2; i < n; ++i) {
			arr[i] = (arr[i - 1] + arr[i - 2]) % 1000000007;
		}

		answer = arr[n - 1];
		return answer;
	}

	public static void main(String[] args) {

		System.out.println(solution(5));

	}
}
