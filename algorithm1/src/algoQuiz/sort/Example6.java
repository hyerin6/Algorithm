package algoQuiz.sort;

import java.util.Arrays;

public class Example6 {

	private static void sort(char[] a) {
		int zeroCount = 0;

		for (char c : a)
			if (c == '0') zeroCount++;

		/*
		 * Arrays.fill(Object obj, param) - 배열 전체 초기화 
		 * Arrays.fill(배열, 시작인덱스, 끝인덱스, 값); - 원하는 부분 초기화
		 * 배열에서, 시작인덱스 <= index < 끝인덱스 위치에 값을 채운다.
		 */
		Arrays.fill(a, 0, zeroCount, '0');
		Arrays.fill(a, zeroCount, a.length, '1');
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] a = "010101110101".toCharArray();
		sort(a);
		System.out.println(Arrays.toString(a));

	}

}
