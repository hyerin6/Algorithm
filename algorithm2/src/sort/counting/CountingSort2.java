package sort.counting;

public class CountingSort2 {
	/*
	 * 데이터의 종류가 정확히 몇 개인지 미리 알 수 있고, (예: 영어 알파벳 소문자 26개)
	 * 데이터 값으로부터 배열 인덱스를 계산할 수 있다면, (예: int index = c - 'a'; )
	 * TreeMap 대신 int 배열을 이용하여 데이터의 수를 셀 수 있다.
	 */
	public static void countingSort(char[] a) {
		int[] counts = new int['z' - 'a' + 1];

		for (char c : a) // 각 문자의 수를 센다
			++counts[c - 'a'];

		int index = 0; // 배열에 값을 채우기 위한 인덱스
		for (int i = 0; i < counts.length; ++i) // 각 문자의 수 만큼 배열에 채운다
			for (int j = 0; j < counts[i]; ++j)
				a[index++] = (char)('a' + i);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] a = "helloworldgoodmorninghowareyou".toCharArray();
		countingSort(a);
		System.out.printf("[%s]\n", new String(a));
	}

}
