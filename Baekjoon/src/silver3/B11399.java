package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11399 {

	// Arrays.sort() 사용 
	public static int solution(int[] times) {
		Arrays.sort(times);

		int prev = times[0];
		int sum = times[0];

		for (int i = 1; i < times.length; i++) {
			sum += (times[i] + prev);
			prev += times[i];
		}

		return sum;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 입력의 범위는 1 ~ 1000이므로 1001개의 index를 둔다.
		int[] times = new int[1001];

		// Counting Sort
		while (N-- > 0) {
			times[Integer.parseInt(st.nextToken())]++;
		}

		int prev = 0;
		int sum = 0;

		for (int i = 0; i < 1001; i++) {
			// 해당 i index가 0이 될 때 까지 반복
			while (times[i]-- > 0) {
				sum += (i + prev);
				prev += i;
			}
		}

		System.out.println(sum);
	}
}
