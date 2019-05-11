package hashtable;

public class Example3a {

	// 수행시간 O(1)
	// 메모리 요구량 O(1)
	/*
	 * 아래의 코드는 저장할 값을 37로 나눈 나머지가 서로 중복되지 않기 때문에 위와 같이 구현할 수 있었다.
	 * 37로 나눈 나머지가 중복된다면, 위 코드는 제대로 작동하지 않는다.
	 * 이 문제를 해결한 것이 해시 테이블 자료구조이다.
	 */
	static class HashTable {

		int[] a;

		public HashTable() {
			a = new int[37];
		}

		public void add(int value) {
			a[value % 37] = value;
		}

		public void remove(int value) {
			a[value % 37] = 0;
		}

		public boolean contains(int value) {
			return a[value % 37] == value;
		}
	}

	public static void main(String[] args) {
		int maxValue = 200, maxCount = 10;
		HashTable hashTable = new HashTable();

		int[] data = { 1, 13, 105, 7, 9, 11, 14, 115, 107, 197 };
		for (int i = 0; i < data.length; ++i)
			hashTable.add(data[i]);

		for (int i = 1;  i <= maxValue; ++i)
			if (hashTable.contains(i))
				System.out.println(i);
	}
}
