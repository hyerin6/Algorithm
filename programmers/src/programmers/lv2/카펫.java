package programmers.lv2;

import java.util.Arrays;

public class 카펫 {

	/*
	문제에서 가로와 세로를 구하라고 했는데
	2 * n + 2 * (m - 2) 이와 같은 식을 이용해서
	브라운을 이용한 식 하나를 구할 수 있다. n + m = (brown + 4) / 2
	이어서 노란색도 이용해보면 (n - 2) * (m - 2) = yellow
	n >= m 조건을 만족해야 하는 점만 주의하면 된다.
	*/

	public static int[] solution(int brown, int yellow) {
		int[] answer = new int[2];

		int sum = (brown + 4) / 2; // m+n
		int m = 3; // 세로
		int n = sum - m; // 가로

		while(n >= 3 && n >= m) {
			// (n - 2) * (m - 2)는 노란색 칸의 개수와 같음.
			if((n - 2) * (m - 2) == yellow){
				answer[0] = n;
				answer[1] = m;
				break;
			}

			n--; m++;
		}

		return answer;
	}

	public static void main(String[] args) {
		int b1 = 10;
		int y1 = 2;
		int[] result1 = solution(b1, y1);
		System.out.println(Arrays.toString(result1));

		int b2 = 8;
		int y2 = 1;
		int[] result2 = solution(b2, y2);
		System.out.println(Arrays.toString(result2));

		int b3 = 24;
		int y3 = 24;
		int[] result3 = solution(b3, y3);
		System.out.println(Arrays.toString(result3));
	}

}
