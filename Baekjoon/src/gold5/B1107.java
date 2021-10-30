package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
버튼이 0부터 9까지 숫자, +와 -가 있다.
+를 누르면 현재 보고있는 채널에서 +1된 채널로 이동하고, -를 누르면 -1된 채널로 이동한다.
채널 0에서 -를 누른 경우에는 채널이 변하지 않고, 채널은 무한대 만큼 있다.
 */
public class B1107 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int answer = 100; // 현재 채널은 100번

		String N = br.readLine();
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int[] broken = new int[10];
		for (int i = 0; i < M; ++i) {
			broken[Integer.parseInt(st.nextToken())] = -1;
		}

		for (int i = 0; i < N.length(); ++i) {
			if (broken[N.charAt(i) - '0'] != -1) {
				sb.append(N.charAt(i));
			} else {
				sb.append(".");
			}
		}

		System.out.println(sb);
	}
}
