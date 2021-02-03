package algoQuiz.sort;

import java.util.Arrays;
import java.util.Comparator;

public class Example2c {
	static void insertionSort(Object[] a, Comparator comparator) {
		for (int i = 1; i < a.length; ++i) {
			Object value = a[i];          // 삽입할 값 보관
			int j;
			for (j = i - 1; j >= 0; --j)  // 뒤로 이동
				if (comparator.compare(a[j], value) > 0)
					a[j + 1] = a[j];
				else
					break;
			a[j + 1] = value;             // 값 삽입
		}
	}

	public static void main(String[] args) {
		Person[] a = new Person[] {
				new Person("홍길동", 18), new Person("임꺽정", 22), new Person("이몽룡", 17),
				new Person("전우치", 23), new Person("심청", 16), new Person("연흥부", 38)
		};

		insertionSort(a, new PersonNameComparator());
		System.out.println(Arrays.toString(a));
	}
}
