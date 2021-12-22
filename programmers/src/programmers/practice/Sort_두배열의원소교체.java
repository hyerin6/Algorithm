package programmers.practice;

import java.util.Arrays;
import java.util.Collections;

public class Sort_두배열의원소교체 {

	public static void main(String[] args) {
		int n = 5;
		int k = 3;

		int[] a = {1, 2, 5, 4, 3};
		Integer[] b = {5, 5, 6, 6, 5};

		// 배열 A는 오름차순 정렬 수행
		Arrays.sort(a);
		// 배열 B는 내림차순 정렬 수행
		Arrays.sort(b, Collections.reverseOrder());

		// 첫 번째 인덱스부터 확인하며, 두 배열의 원소를 최대 K번 비교
		for (int i = 0; i < k; i++) {
			// A의 원소가 B의 원소보다 작은 경우
			if (a[i] < b[i]) {
				// 두 원소를 교체
				int temp = a[i];
				a[i] = b[i];
				b[i] = temp;
			}
			// A의 원소가 B의 원소보다 크거나 같을 때, 반복문을 탈출
			else
				break;
		}

		// 배열 A의 모든 원소의 합을 출력
		long result = 0;
		for (int i = 0; i < n; i++) {
			result += a[i];
		}
		
		System.out.println(result);
	}
}
