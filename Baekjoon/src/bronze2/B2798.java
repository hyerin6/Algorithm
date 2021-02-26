package bronze2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B2798 {
	static int[] A;
	static int N, M;
	static int max = 0;

	static void solution(int index, int count, int sum) {
		if (count == 0) {
			if (sum <= M && sum > max) {
				max = sum;
			}
			return;
		}

		if (A.length - index > count) {
			solution(index + 1, count, sum);
		}

		solution(index + 1, count - 1, sum + A[index]);
	}

	static int search(int[] arr, int N, int M) {
		int result = 0;

		// 3개를 고르기 때문에 첫번째 카드는 N - 2 까지만 순회
		for (int i = 0; i < N - 2; i++) {
			// 첫 번째 카드가 M 보다 크면 skip
			if (arr[i] > M)
				continue;

			// 두 번째 카드는 첫 번째 카드 다음부터 N - 1 까지만 순회
			for (int j = i + 1; j < N - 1; j++) {
				// 두 번째 카드와 첫 번째 카드의 합이 M보다 크면 skip
				if (arr[i] + arr[j] > M)
					continue;

				// 세 번째 카드는 두 번째 카드 다음부터 N 까지 순회
				for (int k = j + 1; k < N; k++) {
					// 3개 카드의 합 변수 temp
					int temp = arr[i] + arr[j] + arr[k];
					// M과 세 카드의 합이 같다면 temp return 및 종료
					if (M == temp) {
						return temp;
					}
					// 세 카드의 합이 이전 합보다 크면서 M 보다 작을 경우 result 갱신
					if (result < temp && temp < M) {
						result = temp;
					}
				}
			}
		}
		// 모든 순회를 마치면 result 리턴
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		A = new int[N];
		for (int i = 0; i < N; ++i) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		solution(0, 3, 0);
		bw.write(max + "\n");

		bw.flush();
		bw.close();
		br.close();
	}
}
