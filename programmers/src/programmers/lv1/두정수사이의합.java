package programmers.lv1;

public class 두정수사이의합 {

//	public static long solution(int a, int b) {
//		long answer = 0;
//
//		int start = Math.min(a, b);
//		int end = Math.max(a, b);
//
//		for (int i = start; i <= end; i++) 
//			answer += i;
//
//		return answer;
//	}

	public static long solution(int a, int b) {
		return sumAtoB(Math.min(a, b), Math.max(b, a));
	}

	public static long sumAtoB(long a, long b) {
		return (b - a + 1) * (a + b) / 2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long result1 = solution(3, 3);
		System.out.println(result1);

		long result2 = solution(5, 3);
		System.out.println(result2);

		long result3 = solution(3, 5);
		System.out.println(result3);

	}

}
