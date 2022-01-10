package silver1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B14891 {
	static int n, w, L;
	static int[] truck;
	static int[] bridge;

	private static int solution() {
		int time = 0;
		int idx = 0;
		int weight = 0;

		while (idx < n) {
			// 트럭 한칸씩 이동
			int reach = bridge[0];
			for (int i = 1; i < w; ++i) {
				bridge[i - 1] = bridge[i];
			}
			bridge[w - 1] = 0;

			// 다리를 건넌 트럭이 있다면 무게 재설정
			if (reach != 0) {
				weight -= reach;
			}

			// 다리에 대기중인 트럭이 올라올 수 있으면 다리에 올라간다.
			if (idx < n && weight + truck[idx] <= L) {
				bridge[w - 1] = truck[idx];
				weight += truck[idx];
				idx++;
			}

			time++;
		}

		// 마지막에 다리에 오른 트럭이 다리를 건너는 시간을 추가
		return time + w;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		truck = new int[n];
		bridge = new int[w];

		String[] input = br.readLine().split(" ");
		for (int i = 0; i < n; ++i) {
			truck[i] = Integer.parseInt(input[i]);
		}

		int answer = solution();
		System.out.println(answer);
	}

}

