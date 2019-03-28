package algoQuiz.sort;
//고급 정렬 엽습 문제 4)
//Person[] 배열 mergeSort sort 구현
import java.util.Arrays;
import java.util.Comparator;

public class AdvancedSorting4 {
	static void merge(Object[] a, Comparator comparator, int start, int mid, int end) {
		int length = end-start+1;
		Object[] temp = new Object[length];
		int i = 0;
		int index1 = start;
		int index2 = mid+1;

		while(index1 <= mid && index2 <= end) {
			if(comparator.compare(a[index1], a[index2]) < 0)
				temp[i++] = a[index1++];
			else 
				temp[i++] = a[index2++];	
		}
		while(index1 <= mid) temp[i++] = a[index1++];
		while(index2 <= end) temp[i++] = a[index2++];

		for(i = 0; i < temp.length; ++i) 
			a[start+i] = temp[i];
	}

	static void mergeSort(Object[] s, int start, int end) {
		if (start >= end) return; 
		int mid = (start + end) / 2; 
		mergeSort(s, start, mid); 
		mergeSort(s, mid + 1, end); 
		merge(s, new PersonNameComparator(), start, mid, end);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person[] a = new Person[] {
				new Person("홍길동", 18), new Person("임꺽정", 22), new Person("이몽룡", 17),
				new Person("전우치", 23), new Person("심청", 16), new Person("연흥부", 38)
		};

		mergeSort(a, 0, a.length-1); 
		System.out.println(Arrays.toString(a));
	}

}
