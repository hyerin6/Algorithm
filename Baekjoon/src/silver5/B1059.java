package silver5;

import java.util.Arrays;
import java.util.Scanner;

/*
 A < B를 만족
 A ≤ x ≤ B를 만족하는 모든 정수 x가 집합 S에 속하지 않는다.
 */
public class B1059 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		int l = sc.nextInt();
		int breakPoint = 0;

		for (int i = 0; i < n; ++i) {
			if (arr[i] == l) {
				System.out.println(0);
				breakPoint = -1;
				break;
			}
		}

		if (breakPoint != -1) {
			breakPoint = 0;
			if (arr[0] >= l) {
				breakPoint = (l - 0) * (arr[0] - l) - 1;
			} else {

				for (int i = 1; i < n; i++) {
					if (arr[i] >= l) {
						breakPoint = (l - arr[i - 1]) * (arr[i] - l) - 1;
						break;
					}
				}
			}
			System.out.println(breakPoint);
		}
	}
}