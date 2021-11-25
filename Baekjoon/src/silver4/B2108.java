package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2108 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[8001];
		int sum = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int mid = 10000;
		int mod = 10000;
		int count = 0;    // 중앙값 빈도 누적 수
		int modMax = 0;   // 최빈값의 최댓값

		for (int i = 0; i < N; ++i) {
			int input = Integer.parseInt(br.readLine());
			numbers[input + 4000]++;
			sum += input;
			if (max < input) {
				max = input;
			}
			if (min > input) {
				min = input;
			}
		}
		boolean flag = false;

		for (int i = min + 4000; i <= max + 4000; i++) {

			if (numbers[i] > 0) {
				/*
				 * <중앙값 찾기>
				 * 누적횟수가 전체 전체 길이의 절반에 못 미친다면
				 */
				if (count < (N + 1) / 2) {
					count += numbers[i];    // i값의 빈도수를 count 에 누적
					mid = i - 4000;
				}

				/*
				 * <최빈값 찾기>
				 * 이전 최빈값보다 현재 값의 빈도수가 더 높을 경우
				 */
				if (modMax < numbers[i]) {
					modMax = numbers[i];
					mod = i - 4000;
					flag = true;    // 첫 등장이므로 true 로 변경
				}
				// 이전 최빈값 최댓값과 동일한 경우면서 한 번만 중복되는 경우
				else if (modMax == numbers[i] && flag == true) {
					mod = i - 4000;
					flag = false;
				}
			}
		}

		System.out.println((int)Math.round((double)sum / N));
		System.out.println(mid);
		System.out.println(mod);
		System.out.println(max - min);
	}
}
