package lesson1;

public class BinaryGap {

	static int solution(int N) {
		int max = 0;
		int count = 0;
		int result = 0;

		while(N > 1) {
			int num = N % 2;
			if(num == 1) {
				count++;
				max = 0;
				// 0을 만났지만 1사이에 있는 0이 아닐수도 있기 때문에 'count >= 1' 조건이 필요하다.
			} else if(count >= 1 && num == 0) { 
				max++;
				result = Math.max(result, max);
			}
			N /= 2;
		}

		// count가 0보다 크면 result를 반환한다.
		return count > 0 ? result : 0;
	}

	public static void main(String[] args) {
		System.out.println(solution(5));
		System.out.println(solution(9));
		System.out.println(solution(529));
		System.out.println(solution(20));
	}

}
