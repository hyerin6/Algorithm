package com.java.coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자_끼워넣기 {
	static int N;
	static int[] nums;
	static int[] oper;

	static int minValue = 1000000000;
	static int maxValue = -1000000000;

	private static void dfs(int depth, int sum) {
		if (depth == N) {
			minValue = Math.min(minValue, sum);
			maxValue = Math.max(maxValue, sum);
			return;
		}

		int base = nums[depth];
		for (int i = 0; i < 4; ++i) {
			if (oper[i] <= 0) {
				continue;
			}
			int tempSum = sum;
			if (i == 0)
				tempSum += base;
			else if (i == 1)
				tempSum -= base;
			else if (i == 2)
				tempSum *= base;
			else
				tempSum /= base;
			oper[i]--;
			dfs(depth + 1, tempSum);
			oper[i]++;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		oper = new int[4]; // +, -, *, /
		oper[0] = Integer.parseInt(st.nextToken());
		oper[1] = Integer.parseInt(st.nextToken());
		oper[2] = Integer.parseInt(st.nextToken());
		oper[3] = Integer.parseInt(st.nextToken());

		dfs(1, nums[0]);
		System.out.println(maxValue);
		System.out.println(minValue);
	}
}
