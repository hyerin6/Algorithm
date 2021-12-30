package lesson5;

public class CountDiv {

	public static int solution(int A, int B, int K) {
		if (A % K == 0) {
			return B / K - A / K + 1;
		}
		
		return B / K - A / K;
	}

	public static void main(String[] args) {
		System.out.println(solution(6, 11, 2));
	}
}
