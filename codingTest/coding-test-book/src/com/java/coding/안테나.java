package com.java.coding;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 안테나 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] point = new int[n];
		for (int i = 0; i < n; ++i) {
			point[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(point);
		System.out.println(point[(n - 1) / 2]);
	}
}
