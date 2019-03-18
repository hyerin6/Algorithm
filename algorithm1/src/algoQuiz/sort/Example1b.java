package algoQuiz.sort;
import java.util.Arrays;

public class Example1b {

	// String 배열 삽입 정렬
	static void insertionSort(String[] s) {
		for(int i = 1; i < s.length; ++i) {
			String value = s[i];
			int j;
			for(j = i - 1; j >= 0; --j) {
				if (s[j].compareTo(value) > 0) 
					s[j + 1] = s[j];
				else break;
			}
			s[j + 1] = value;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = { "zero", "one", "two", "three", "four", "five", "six", "seven" };

		insertionSort(s);
		System.out.println(Arrays.toString(s));
	}

}
