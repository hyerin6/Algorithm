package silver1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
N이 최대 15라서 재귀를 사용하며 시간 초과가 발생
시간을 줄이기 위해서 일일히 좌표에 접근하지 않고 한번에 가는 방법을 생각해야한다.
 */
public class B1074_timeout {

	private static int r;
	private static int c;
	private static int n;
	private static int count;
	private static int[] dx = {0, 1, 0, 1};
	private static int[] dy = {0, 0, 1, 1};

	private static void dfs(int num, int row, int col) {
		if (num == 2) {
			for (int i = 0; i < 4; i++) {
				int r2 = row + dy[i];
				int c2 = col + dx[i];
				if (r2 == r && c2 == c) {
					System.out.println(count);
					System.exit(0);
				}
				count++;
			}
			return;
		}

		dfs(num / 2, row, col);
		dfs(num / 2, row, col + num / 2);
		dfs(num / 2, row + num / 2, col);
		dfs(num / 2, row + num / 2, col + num / 2);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = (int)Math.pow(2, Integer.parseInt(input[0]));
		r = Integer.parseInt(input[1]);
		c = Integer.parseInt(input[2]);
		dfs(n, 0, 0);
	}
}
