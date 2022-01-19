package com.java.coding;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기설치 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] house = new int[n];

		for (int i = 0; i < n; ++i) {
			house[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(house);

		int left = 1; // 가능한 최소 거리(min gap)
		int right = house[n - 1] - house[0]; // 가능한 최대 거리(max gap)
		int diff = 0;
		int ans = 0;

		while (left <= right) {
			int mid = (left + right) / 2;
			int start = house[0]; // 첫째 집에는 무조건 공유기를 설치한다고 가정
			int count = 1;
			// 현재의 mid 값을 이용해 공유기를 설치하기
			for (int i = 0; i < n; i++) { // 앞에서부터 차근차근 설치
				diff = house[i] - start;
				if (diff >= mid) { // 만약 첫번째 집과의 거리가 더 크다면 찾았다고 count 올려주고, 내가 찾는집에 이번 집을 넣어준다.
					count++;
					start = house[i];
				}
			}
			// C개 이상의 공유기를 설치할 수 있는 경우, 거리를 증가시키기
			if (count >= c) {
				ans = mid;
				left = mid + 1;
			} else { // C개 이상의 공유기를 설치할 수 없는 경우, 거리를 감소시키기
				right = mid - 1;
			}
		}
		System.out.println(ans);
	}
}