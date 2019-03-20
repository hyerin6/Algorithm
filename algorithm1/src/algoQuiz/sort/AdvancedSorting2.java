package algoQuiz.sort;
import java.util.Arrays;
//고급 정렬 엽습 문제 2)
//String[] 배열 quick sort 구현
public class AdvancedSorting2 {
	static void swap(String[] s, int i, int j) {
		String temp = s[i];
		s[i] = s[j];
		s[j] = temp;
	}

	static int partition(String[] s, int start, int end) {
		String value = s[end];
		int i = start - 1;
		for(int j = start; j < end; ++j) {
			if(s[j].compareTo(value) < 0) 
				swap(s, ++i, j);
		}
		swap(s, i + 1, end);
		return i + 1;
	}

	static void quickSort(String[] s, int start, int end) {
		if(start >= end) return;
		int mid = partition(s, start, end);
		quickSort(s, start, mid-1);
		quickSort(s, mid+1, end);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = { "zero", "one", "two", "three", "four", "five", "six", "seven" }; 
		quickSort(a, 0, a.length-1); 
		System.out.println(Arrays.toString(a));
	}

}
