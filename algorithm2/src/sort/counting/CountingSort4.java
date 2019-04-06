package sort.counting;
import java.util.Arrays;

public class CountingSort4 {

	// 성별로 정렬 (여자가 앞, 남자가 뒤)
	public static void countingSort(Person[] a) {
		int 여자수 = 0;
		for (Person p : a) // 여자의 수를 센다
			if (p.getSex().equals("여자")) ++여자수;
		Person[] r = new Person[a.length];
		int 여자index = 0, 남자index = 여자수;
		for (Person p : a)
			if (p.getSex().equals("여자")) r[여자index++] = p;
			else r[남자index++] = p;
		for (int i = 0; i < a.length; ++i)
			a[i] = r[i];
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

		countingSort(a);
		System.out.println(Arrays.toString(a));
	}
}