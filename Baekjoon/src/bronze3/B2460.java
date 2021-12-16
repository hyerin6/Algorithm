package bronze3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2460 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int max = Integer.MIN_VALUE;
		int cnt = 0;

		for (int i = 0; i < 10; ++i) {
			st = new StringTokenizer(br.readLine());
			int out = Integer.parseInt(st.nextToken());
			int in = Integer.parseInt(st.nextToken());
			cnt -= out;
			cnt += in;
			if (max < cnt) {
				max = cnt;
			}
		}
		
		System.out.println(max);
	}
}
