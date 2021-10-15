package programmers.lv1;

public class 나머지가_1이되는_수_찾기 {

	public static int solution(int n) {
		int answer = 0;

		for (int i = 1; i < n; ++i) {
			if (n % i == 1)
				return i;
		}

		return answer;
	}

	public static void main(String[] args) {
		int result = solution(10);
		System.out.println(result);
	}
}
