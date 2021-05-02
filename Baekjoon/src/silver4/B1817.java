package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 첫째 줄에 책의 개수 N과 박스에 넣을 수 있는 최대 무게 M이 주어진다. 
/*
6 10
5 5 5 5 5 5
 */
public class B1817 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		if (N == 0) {
			System.out.println(0);
			return;
		}

		int[] book = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; ++i) {
			book[i] = Integer.parseInt(st.nextToken());
		}

		int temp = 0;
		int cnt = 1;
		for (int i = N - 1; i >= 0; --i) {
			temp += book[i];
			if (temp > M) {
				++cnt;
				temp = book[i];
			}
		}

		System.out.println(cnt);

	}
}
