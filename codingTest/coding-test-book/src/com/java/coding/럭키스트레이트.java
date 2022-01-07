package com.java.coding;

import java.io.IOException;

public class 럭키스트레이트 {

	public static void solution(int N) {
		char[] numbers = String.valueOf(N).toCharArray();
		int sum = 0;

		for (int i = 0; i < numbers.length; ++i) {
			if (i >= numbers.length / 2) {
				sum -= numbers[i] - '0';
			} else {
				sum += numbers[i] - '0';
			}
		}

		if (sum == 0) {
			System.out.println("LUCKY");
			return;
		}
		System.out.println("READY");
	}

	public static void main(String[] args) throws IOException {
		solution(123402);
	}
}
