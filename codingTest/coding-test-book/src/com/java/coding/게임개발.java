package com.java.coding;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 게임개발 {
	public static int n, m, x, y, direction;
	public static int[][] d = new int[50][50];
	public static int[][] arr = new int [50][50];

	public static int dx[] = {-1, 0, 1, 0};
	public static int dy[] = {0, 1, 0, -1};

	public static void turnLeft() {
		direction -= 1;
		if (direction == -1) {
			direction = 3;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n= Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		direction =Integer.parseInt(st.nextToken());
		d[x][y] = 1;
		for(int i =0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 1;
		int turn_time = 0;
		while (true) {
			// 왼쪽으로 회전
			turnLeft();
			int nx = x + dx[direction];
			int ny = y + dy[direction];
			// 회전한 이후 정면에 가보지 않은 칸이 존재하는 경우 이동
			if (d[nx][ny] == 0 && arr[nx][ny] == 0) {
				d[nx][ny] = 1;
				x = nx;
				y = ny;
				cnt += 1;
				turn_time = 0;
				continue;
			}
			// 회전한 이후 정면에 가보지 않은 칸이 없거나 바다인 경우
			else turn_time += 1;
			// 네 방향 모두 갈 수 없는 경우
			if (turn_time == 4) {
				nx = x - dx[direction];
				ny = y - dy[direction];
				// 뒤로 갈 수 있다면 이동하기
				if (arr[nx][ny] == 0) {
					x = nx;
					y = ny;
				}
				// 뒤가 바다로 막혀있는 경우
				else break;
				turn_time = 0;
			}
		}

		bw.write(cnt + "\n");
		bw.close();
		br.close();
	}
}
