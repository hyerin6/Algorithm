package algoQuiz.sort;

import java.util.Arrays;

public class Example1c {

	static void swap(String[] s, int i, int j) {
		String temp = s[i];
		s[i] = s[j];
		s[j] = temp;
	}

	// String 배열 버블 정렬
	static void bubbleSort(String[] s) {
		for(int i = s.length - 1; i >= 1; --i) {
			boolean 완료 = true;
			for(int j = 0; j < i; ++j) {
				if(s[j].compareTo(s[j + 1]) > 0) {
					swap(s, j, j+1);
					완료 = false;
				}	
			}
			if(완료 == true) break;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = { "zero", "one", "two", "three", "four", "five", "six", "seven" };

		bubbleSort(s);
		System.out.println(Arrays.toString(s));

	}

}
