package sort.counting;

public class CountingSort3 {

	// '0' 문자의 수만 세면 된다.
	// '1' 문자의 수는, 입력 배열의 길이 - '0' 문자의 수 이기 때문이다.
	public static void countingSort(char[] a) {
		int count = 0;
		for (char c : a) // 0 문자의 수를 센다
			if (c == '0') ++count;
		for (int i = 0; i < a.length; ++i)
			a[i] = (i < count) ? '0' : '1';
	}

	public static void main(String[] args) {
		char[] a = "0101000010100010111110011100000001111".toCharArray();
		countingSort(a);
		System.out.printf("[%s]\n", new String(a));
	}
}