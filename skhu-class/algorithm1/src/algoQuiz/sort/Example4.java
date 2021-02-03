package algoQuiz.sort;

import java.util.Arrays;

public class Example4 {

	// 문자 배열 char[] 오름차순으로 배열 정렬하기
	private static void sort(char[] a) {
		Arrays.sort(a);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] a = "hello world!".toCharArray();
		sort(a);
		System.out.println(Arrays.toString(a));

	}

}
