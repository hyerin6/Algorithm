package algoQuiz.sort;

import java.util.Arrays;
import java.util.Comparator;

public class Example2a {

	// 배열 a에서 i 위치와 j 위치의 값을 서로 바꾼다.
	static void swap(Object[] a, int i, int j) { 
		Object temp = a[i]; 
		a[i] = a[j]; 
		a[j] = temp; 
	}

	static int findMin(Object[] a, int start, Comparator comparator) {
		Object minValue = a[start]; 
		int minIndex = start; 
		for (int i = start + 1; i < a.length; ++i) { 
			if (comparator.compare(a[i], minValue) < 0) { 
				minValue = a[i]; minIndex = i; 
			} 
		}
		return minIndex; 
	}

	static void selectionSort(Object[] a, Comparator comparator) {
		for (int i = 0; i < a.length - 1; ++i) {
			int minIndex = findMin(a, i, comparator); 
			swap(a, i, minIndex);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person[] a = new Person[] {
				new Person("홍길동", 18), new Person("임꺽정", 22), new Person("이몽룡", 17),
				new Person("전우치", 23), new Person("심청", 16), new Person("연흥부", 38)
		};

		selectionSort(a, new PersonNameComparator()); 
		System.out.println(Arrays.toString(a));

	}
}


