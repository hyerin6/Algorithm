package programmers.line2018;

import java.math.BigInteger;
import java.util.Scanner;

/*
INPUT : N K M
N - 스티커, 테마 각각의 개수
K - K개의 스티커 구매 가능
M - 샐리는 이미 M개의 스티커를 구매함

구매한 스티커의 수는 M이기 때문에
구매한 테마의 수는 K-M이 된다.
 */
public class Main4 {

	static BigInteger f(int n) { // factorial
		BigInteger result = BigInteger.valueOf(1);
		for (int i = 2; i <= n; ++i) {
			result = result.multiply(BigInteger.valueOf(i));
		}
		return result;
	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int count = scanner.nextInt();
			for (int i = 0; i < count; ++i) {
				int N = scanner.nextInt();
				int K = scanner.nextInt();
				int M = scanner.nextInt();
				int H = K - M;
				BigInteger r1 = f(N).divide(f(M)).divide(f(N - M));
				BigInteger r2 = f(N).divide(f(H)).divide(f(N - H));
				BigInteger r = r1.multiply(r2).remainder(BigInteger.valueOf(1003001));
				System.out.println(r);
			}
		}
	}
}
