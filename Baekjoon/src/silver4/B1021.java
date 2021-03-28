package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B1021 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // 큐 크기
		int M = Integer.parseInt(st.nextToken()); // 뽑아내려고 하는 수
		st = new StringTokenizer(br.readLine(), " ");

		int answer = 0;
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= N; ++i) {
			list.add(i);
		}

		for (int i = 0; i < M; ++i) {
			int num = Integer.parseInt(st.nextToken());
			while (true) {
				if (list.get(0) == num) {
					list.remove(0);
					break;
				} else {
					int mid = list.size() / 2;
					if (list.indexOf(num) <= mid) {
						list.add(list.size() - 1, list.remove(0));
					} else {
						list.add(0, list.remove(list.size() - 1));
					}
					answer++;
				}
			}
		}

		System.out.println(answer);
	}
}
