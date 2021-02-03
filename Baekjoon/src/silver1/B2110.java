package silver1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2110 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer t = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(t.nextToken()); // 집
		int C = Integer.parseInt(t.nextToken()); // 공유기 

		int[] list = new int[N];
		for (int i = 0; i < N; ++i) {
			t = new StringTokenizer(br.readLine());
			list[i] = Integer.parseInt(t.nextToken());
		}
		Arrays.sort(list);

		int left = 1;
		int right = list[N - 1];
		int d = 0;

		// 이분 탐색으로 가장 긴 거리를 구한다.
		while (left <= right) {
			int mid = (left + right) / 2; // 중간값으로 지정
			int cnt = 1; // 0번째에는 공유기 설치했다고 가정하고 시작
			int start = list[0]; // 0에 공유기 설치했으니까 시작점으로 두고, mid보다 크거나 같은 최초지점 찾으면, 그 점에 공유기 설치.

			for (int i = 1; i < N; ++i) {
				if (list[i] - start >= mid) {
					start = list[i];
					cnt++;
				}
			} // 위에서 설치된 공유기 개수 cnt에 저장 

			if (cnt >= C) {
				d = mid;
				left = mid + 1;
			} else
				right = mid - 1;
		}

		System.out.println(d);

	}

}
