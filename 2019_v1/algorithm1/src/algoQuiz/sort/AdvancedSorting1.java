package algoQuiz.sort;
import java.util.Arrays;
// 고급 정렬 엽습 문제 1)
// String[] 배열 merge sort 구현
public class AdvancedSorting1 {
	static void merge(String[] s, int start, int mid, int end) {
		int length = end-start+1;
		String[] temp = new String[length];
		int i = 0;
		int index1 = start;
		int index2 = mid+1;

		while(index1 <= mid && index2 <= end) {
			if(s[index1].compareTo(s[index2]) < 0)
				temp[i++] = s[index1++];
			else 
				temp[i++] = s[index2++];	
		}
		while(index1 <= mid) temp[i++] = s[index1++];
		while(index2 <= end) temp[i++] = s[index2++];

		for(i = 0; i < temp.length; ++i) 
			s[start+i] = temp[i];
	}

	static void mergeSort(String[] s, int start, int end) {
		if (start >= end) return; 
		int mid = (start + end) / 2; 
		mergeSort(s, start, mid); 
		mergeSort(s, mid + 1, end); 
		merge(s, start, mid, end);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = { "zero", "one", "two", "three", "four", "five", "six", "seven" }; 
		mergeSort(s, 0, s.length-1); 
		System.out.println(Arrays.toString(s));

	}

}
