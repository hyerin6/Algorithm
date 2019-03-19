package algoQuiz.sort;

import java.util.Arrays;

public class Example5 {

	private static void sort(char[] a) {
		int[] count = new int[26];
		for(int i = 0; i < a.length; ++i)
			count[a[i] - 'a']++; // a = 97 
		int index = 0;
		for(int i = 0; i < count[i]; ++i) {
			char c = (char)('a' + i);
			for (int j = 0; j < count[i]; ++j)
				a[index++] = c;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] a = "helloworld".toCharArray();
		sort(a);
		System.out.println(Arrays.toString(a));

	}

}
