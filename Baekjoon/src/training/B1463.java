package training;
import java.util.Scanner;

/* 백준 1463 - 1로 만들기
 *
 * 정수 x에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
 * 1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
 * 2. X가 2로 나누어 떨어지면, 2로 나눈다.
 * 3. 1을 뺀다.
 * 
 * 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
 */


// 참고 - https://kgh940525.tistory.com/entry/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-1463-1%EB%A1%9C-%EB%A7%8C%EB%93%A4%EA%B8%B0TopDownBottomUp-C
public class B1463 {

	// 재귀호출은 중복 호출이 너무 많다. 동적 프로그래밍으로 구현하라.
	public static int solution1(int n) {
		System.out.printf("%d ", n); 
		if(n == 1) return 0;
		int r2 = Integer.MAX_VALUE, r3 = Integer.MAX_VALUE;
		int r1 = 1 + solution1(n - 1); // 메소드 안에서 다시 호출되는 것이기 때문에 +1
		if (n % 3 == 0) r3 = 1 + solution1(n / 3);
		if (n % 2 == 0) r2 = 1 + solution1(n / 2);
		return Math.min(r1, Math.min(r2, r3));
	}

	// 동적 프로그래밍 
	static int[] DP;
	public static int solution2(int n) {
		if (n == 1) return 0; 
		if (DP[n] > 0) return DP[n]; 
		int r2 = Integer.MAX_VALUE, r3 = Integer.MAX_VALUE; 
		int r1 = 1 + solution2(n - 1); 
		if (n % 3 == 0) r3 = 1 + solution2(n / 3); 
		if (n % 2 == 0) r2 = 1 + solution2(n / 2); 
		return DP[n] = Math.min(r1, Math.min(r2, r3));
	}

	// 반복문으로 구현 
	public static int solution3(int n) {
		int[] a = new int[Math.max(4, n + 1)]; // 배열의 최소크기 4, 배열의 마지막 인덱스 X 
		a[1] = 0; 
		a[2] = 1; 
		a[3] = 1; 
		for (int i = 4; i <= n; ++i) { 
			a[i] = a[i-1] + 1; // x에서 1을 빼는 것부터 시작했을 때, 연산 횟수 
			if (i % 2 == 0) a[i] = Math.min(a[i], a[i/2] + 1); // x에서 2를 나누는 것부터 시작했을 때, 연산수 
			if (i % 3 == 0) a[i] = Math.min(a[i], a[i/3] + 1); // x에서 3을 나누는 것부터 시작했을 때, 연산수 
		} 
		return a[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		System.out.println("\n\n solution1: " + solution1(n));
		DP = new int[n + 1]; 
		System.out.println("\n solution2: " + solution2(n)); 
		System.out.println("\n solution3: " + solution3(n));
	}

}
