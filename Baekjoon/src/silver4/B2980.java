package silver4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B2980 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int pre = 0;
		int time = 0;

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			int D = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int G = Integer.parseInt(st.nextToken());

			time += D - pre;
			pre = D;

			int red = time % (R + G); // 지연을 고려할 필요가 없는 경우
			if (red <= R) { // 값이 작다면 빨간불이므로 누적된다.
				time += (R - red);
			}
		}

		bw.write(time + (L - pre) + "\n");
		bw.close();
		br.close();
	}

}
