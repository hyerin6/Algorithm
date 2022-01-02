package com.java.coding;

import java.util.Arrays;

public class 큰수의법칙 {

	public static int solution(int[] arr, int m, int k) {
		Arrays.sort(arr);

		int first = arr[arr.length - 1];
		int second = arr[arr.length - 2];

		// 가장 큰 수가 반복되는 횟수
		int count = (m / (k + 1)) * k;
		count += m % (k + 1);

		int result = 0;
		result += count * first;
		result += (m - count) * second;

		System.out.println(result);
		return result;
	}

	public static void main(String[] args) {
		int[] arr = {2, 3, 4, 5, 6, 7, 8};
		int k = 9;
		int m = 3;
		solution(arr, k, m);
	}
}
