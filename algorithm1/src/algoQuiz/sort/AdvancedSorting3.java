package algoQuiz.sort;
import java.util.Arrays;
import java.util.Comparator;
// 고급 정렬 엽습 문제 2)
// Person[] 배열 quickSort sort 구현

public class AdvancedSorting3 {
	static void swap(Object[] a, int i, int j) {
		Object temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	static int partition(Object[] a, Comparator comparator, int start, int end) {
		int i = start - 1;
		Object value = a[end];

		for(int j = start; j < end; ++j) {
			if(comparator.compare(a[j], value) < 0) 
				swap(a, ++i, j);
		}
		swap(a, i + 1, end);
		return i + 1;
	}

	static void quickSort(Object[] a, int start, int end) {
		if(start >= end) return;
		int middle = partition(a, new PersonNameComparator(), start, end); // 배열 나누기
		quickSort(a, start, middle-1);         // 1구역 정렬
		quickSort(a, middle+1, end);           // 2구역 정렬
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person[] a = new Person[] {
				new Person("홍길동", 18), new Person("임꺽정", 22), new Person("이몽룡", 17),
				new Person("전우치", 23), new Person("심청", 16), new Person("연흥부", 38)
		};

		quickSort(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));

	}

}
