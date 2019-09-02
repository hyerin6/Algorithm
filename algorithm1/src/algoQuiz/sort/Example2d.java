package algoQuiz.sort;

import java.util.Arrays;
import java.util.Comparator;

public class Example2d {
	// 배열 a에서 i 위치와 j 위치의 값을 서로 바꾼다
	static void swap(Object[] a, int i, int j) {
		Object temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	// bubble sort
	static void bubbleSort(Object[] a, Comparator comparator) {
		for (int i = a.length - 1; i >= 1; --i) {
			boolean 완료 = true;
			for (int j = 0; j < i; ++j) {
				if (comparator.compare(a[j], a[j + 1]) > 0) {
					swap(a, j, j + 1);
					완료 = false;
				}
			}
			if (완료) break;
		}
	}

	public static void main(String[] args) {
		Person[] a = new Person[] {
				new Person("홍길동", 18), new Person("임꺽정", 22), new Person("이몽룡", 17),
				new Person("전우치", 23), new Person("심청", 16), new Person("연흥부", 38)
		};

		bubbleSort(a, new PersonNameComparator());
		System.out.println(Arrays.toString(a));
	}
}
