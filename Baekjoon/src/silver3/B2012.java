package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
문제에서 N의 범위가 500,000 인데, 만약 모든 학생이 자신의 등수를 1로 예상할경우,
|1-500,000| x 500,500 이 되어서 int의 범위를 벗어난다.
따라서 불만도의 자료형을 long 으로 선언한다.
 */

// https://www.acmicpc.net/problem/2012
public class B2012 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] score = new int[N];

		for (int i = 0; i < N; ++i) {
			score[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(score);

		long answer = 0;
		for (int i = 1; i <= N; ++i) {
			answer += Math.abs(score[i - 1] - i);
		}

		System.out.println(answer);
	}

}
