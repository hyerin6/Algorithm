package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://blog.naver.com/hyerin_0611/222320242740
public class B1337 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);

		int left = 0;
		int right = 0;
		int min = Integer.MAX_VALUE;

		while (right >= left) {
			if (right >= arr.length) {
				break;
			}
			if (arr[right] - arr[left] > 4) {
				left++;
			} else {
				int need = 5 - (right - left + 1);
				min = Math.min(min, need);
				right++;
			}
		}

		System.out.println(min);
	}
}
