package silver1;

public class B10844_v2 {

	static final int M = 1000000000;
	static long[][] 결과배열;

	static long 계단수(int 길이, int 앞자리) {
		if (길이 <= 0)
			return 1;
		long 결과 = 0;
		if (앞자리 - 1 >= 0)
			결과 = (결과 + 계단수(길이 - 1, 앞자리 - 1)) % M;
		if (앞자리 + 1 <= 9)
			결과 = (결과 + 계단수(길이 - 1, 앞자리 + 1)) % M;
		return 결과배열[길이][앞자리] = 결과;
	}

	static long solution(int N) {
		결과배열 = new long[N + 1][10];
		long 결과 = 0;
		for (int i = 1; i <= 9; ++i)
			결과 = (결과 + 계단수(N - 1, i)) % M;
		return 결과;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(1));
		System.out.println(solution(2));
	}

}
