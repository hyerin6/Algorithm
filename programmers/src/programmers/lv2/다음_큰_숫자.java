package programmers.lv2;

public class 다음_큰_숫자 {

	public static int solution(int n) {
		int nBit = Integer.bitCount(n);
		int answer = n;

		while (true) {
			answer++;
			if (nBit == Integer.bitCount(answer)) {
				break;
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(78));
		System.out.println(solution(15));
	}
}
