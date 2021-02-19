package programmers.lv2;

import java.util.Arrays;

public class 이진_변환_반복하기 {

	public static int[] solution(String s) {
		int[] answer = {0, 0};
		int cnt = 0;
		int sum = 0;

		while (true) {
			int one = count(s);
			String binary = Integer.toBinaryString(one);
			cnt++;
			sum += (s.length() - one);

			if ("1".equals(binary)) {
				break;
			}

			s = binary;
		}

		answer[0] = cnt;
		answer[1] = sum;

		return answer;
	}

	public static int count(String s) {
		int cnt = 0;

		for (char c : s.toCharArray()) {
			if (c == '1')
				cnt++;
		}

		return cnt;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("110010101001")));
		System.out.println(Arrays.toString(solution("01110")));
		System.out.println(Arrays.toString(solution("1111111")));
	}
}
