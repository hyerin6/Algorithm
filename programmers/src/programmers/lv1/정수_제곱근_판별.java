package programmers.lv1;

public class 정수_제곱근_판별 {

	/* 
	 * public static double sqrt(double a)
	 * Math.sqrt() 메소드를 사용하면 쉽게 제곱근을 구할 수 있다. 주의할 점은, 반환타입이 double이다.
	 * 
	 * public static double pow(double a, double b)
	 * Math.pow() 메소드를 사용하면 a의 b제곱을 구할 수 있다.
	 */

	private static long solution(long n) {
		// 제곱근에 다시 2를 제곱해서 n 과 같다면 제곱근은 정수이다.
		if(Math.pow((int)Math.sqrt(n), 2) == n)
			return (long) Math.pow(Math.sqrt(n) + 1, 2);
		return -1; 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(solution(121));
		System.out.println(solution(3));

	}

}
