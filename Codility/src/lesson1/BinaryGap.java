package lesson1;

public class BinaryGap {

	static int solution(int n) {
		int max = 0, num = 0, count = 0, result = 0;

		while(n > 0) {
			// 이진수로 변환
			num = n % 2;
			if(num == 1) { // 1을 만나면 count를 시작하고 max를 다시 0으로 초기화한다. 
				count++;
				max = 0;
				// 0을 만났지만 1사이에 있는 0이 아닐수도 있기 때문에 'count >= 1' 조건이 필요하다.
			} else if(count >= 1 && num == 0) { 
				max++;
				// 현재 0의 수가 더 많다면 result에 max 대입
				if(result < max) 
					result = max;
			}
			n /= 2;
		}
		// count가 0보다 크면 result를 반환한다.
		return count > 0 ? result : 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(5));	 // 101
		System.out.println(solution(9));	 // 1001
		System.out.println(solution(529));   // 1000010001 
		System.out.println(solution(20));    // 10100

	}

}
