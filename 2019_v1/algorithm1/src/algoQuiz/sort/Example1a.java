package algoQuiz.sort;

import java.util.Arrays;

/*
 * String[] 배열 정렬을 구현하라. 
 * 참고: int 비교    if (a > b)
 * String 객체 비교  if (a.compareTo(b) > 0)
 */
public class Example1a {
	static void swap(String[] s, int i, int j) {
		String temp = s[i];
		s[i] = s[j];
		s[j] = temp;
	}

	static int findMin(String[] s, int start) {
		int min = start;

		for(int i = start + 1; i < s.length; ++i) 
			if(s[i].compareTo(s[min]) < 0)
				min = i;

		return min;
	}

	static void selectionSort(String[] s) {
		for(int i = 0; i < s.length-1; ++i) {
			int min = findMin(s, i);
			swap(s, i, min);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = { "zero", "one", "two", "three", "four", "five", "six", "seven" };

		selectionSort(s);
		System.out.println(Arrays.toString(s));

	}

}
