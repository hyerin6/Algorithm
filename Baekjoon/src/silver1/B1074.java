package silver1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1074 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int n = (int)Math.pow(2, N);
		int count = 0;
		int x = 0;
		int y = 0;

		/**
		 * 사각형 절반으로 나눠서 각 사분면으로 계산
		 * n 이 1 이 된다는 것은 x, y 좌표가 r, c랑 같아진다는 것
		 */
		while (n > 0) {
			n /= 2;

			// x, y 보다 작으면 위로 왼쪽 위로 count
			if (r < x + n && c < y + n) {
				count += n * n * 0;
			}
			// x보다 작으면 오른쪽 위로 count
			else if (r < x + n) {
				count += n * n * 1;
				y += n;
			}
			// y보다 작으면 왼쪽 아래로 count
			else if (c < y + n) {
				count += n * n * 2;
				x += n;
			}
			// x, y 보다 크거나 같으면 오른쪽 아래로 count
			else {
				count += n * n * 3;
				x += n;
				y += n;
			}

			if (n == 1) {
				System.out.println(count);
				break;
			}
		}
	}

}