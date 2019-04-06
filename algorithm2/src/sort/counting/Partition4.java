package sort.counting;

import java.util.Arrays;

public class Partition4 {
	public static void swap(Person[] a, int i, int j) {
		Person temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	// 배열을 분리 (여자가 앞, 남자가 뒤)
	public static void partition(Person[] a) {
		int i = -1; // 1구역, 즉 여자 구역의 끝
		for (int j = 0; j < a.length; ++j)
			if (a[j].getSex().equals("여자"))
				swap(a, ++i, j);
	}

	public static void main(String[] args) {
		Person[] a = { new Person("홍길동", "남자", "O"),
				new Person("전우치", "남자", "A"),
				new Person("성춘향", "여자", "AB"),
				new Person("이몽룡", "남자", "D"),
				new Person("심청", "여자", "O"),
				new Person("임꺽정", "남자", "A"),
				new Person("장길산", "남자", "AB")
		};

		partition(a);
		System.out.println(Arrays.toString(a));
	}
}
