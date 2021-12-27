package programmers.lv2;

public class 배달 {

	private static final int INF = 500001;

	public static int solution(int N, int[][] road, int K) {
		int[][] map = new int[N][N];

		for (int i = 0; i < map.length; ++i) {
			for (int j = 0; j < map.length; ++j) {
				if (i == j) {
					map[i][j] = 0;
					continue;
				}
				map[i][j] = INF;
			}
		}

		for (int i = 0; i < road.length; ++i) {
			if (map[road[i][0] - 1][road[i][1] - 1] < road[i][2]) {
				continue;
			}
			map[road[i][0] - 1][road[i][1] - 1] = road[i][2];
			map[road[i][1] - 1][road[i][0] - 1] = road[i][2];
		}

		// 플로이드 워셜 알고리즘
		for (int k = 0; k < N; ++k) {
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}

		int count = 0;
		for (int i = 0; i < map.length; i++) {
			if (map[0][i] <= K) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[][] road = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
		int answer = solution(5, road, 3);
		System.out.println(answer);
	}
}
