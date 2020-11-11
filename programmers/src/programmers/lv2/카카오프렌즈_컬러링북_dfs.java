package programmers.lv2;

import java.util.Arrays;

public class 카카오프렌즈_컬러링북_dfs {

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] temp;

	public static int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;
		int width = 0;
		temp = picture;

		for(int i = 0; i < m; ++i) {
			for(int j = 0; j < n; ++j) {
				if(temp[i][j] != 0) {
					width = dfs(i, j, m, n, temp[i][j]);
					if(maxSizeOfOneArea < width) {
						maxSizeOfOneArea = width;
					}
					numberOfArea++;
				}
			}
		}

		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;

		return answer;
	}

	private static int dfs(int x, int y, int m, int n, int prev) {
		int temp_count = 1;

		if(temp[x][y] != prev) return 0;
		temp[x][y] = 0;

		for(int i = 0; i < 4; ++i) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if(nx < 0 || nx >= m || ny < 0 || ny >= n || temp[nx][ny] == 0) continue;
			if(temp[nx][ny] != prev) continue;
			temp_count += dfs(nx, ny, m, n, prev);
		}

		return temp_count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m1 = 6;
		int n1 = 4;
		int[][] picture1 = {{1, 1, 1, 0}, {1, 2, 2, 0}, 
				{1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		int[] result1 = solution(m1, n1, picture1);
		System.out.println(Arrays.toString(result1));

		int m2 = 6;
		int n2 = 4;
		int[][] picture2 = {{1, 1, 1, 0}, {1, 1, 1, 0}, 
				{0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}};
		int[] result2 = solution(m2, n2, picture2);
		System.out.println(Arrays.toString(result2));
	}

}
