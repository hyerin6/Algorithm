package com.java.coding;

/*
이 유형은 완전 탐색 유형으로 분류된다.
일반적으로 완전 탐색 알고리즘은 비효율적인 시간 복잡도를 가지고 있으므로
데이터 개수가 큰 경우 정상적으로 동작하지 않을 수 있다.
확인(탐색)해야 할 전체 데이터의 개수가 100만개 이하일 때 완전 탐색을 사용하면 적절하다.
 */
public class 시각 {

	private static int count(int h) {
		int cnt = 0;
		for (int i = 0; i < h + 1; ++i) {
			for (int j = 0; j < 60; ++j) {
				for (int l = 0; l < 60; ++l) {
					if (i % 10 == 3 || j / 10 == 3 || j % 10 == 3 || l / 10 == 3 || l % 10 == 3) {
						cnt++;
					}
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		System.out.println(count(5));
	}
}
