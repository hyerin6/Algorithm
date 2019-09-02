package hashtable;

public class Example1a {

	// add, remove, contains 메소드의 수행 시간 전부 O(1)
	// 하지만 메모리 사용량은 저장할 정수의 최대값에 비례한다. 
	// (a 배열의 크기 = 201) 메모리 낭비가 너무 심하다. 
	static class HashTable {

		int[] a;

		public HashTable(int n) {
			a = new int[n + 1];
		}

		public void add(int value) {
			a[value] = value;
		}

		public void remove(int value) {
			a[value] = 0;
		}

		public boolean contains(int value) {
			return a[value] == value;
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maxValue = 200, maxCount = 10; // maxCount는 그냥 10개만 저장하겠다는 의미
		HashTable hashTable = new HashTable(maxValue);

		int[] data = { 1, 13, 105, 7, 9, 11, 14, 115, 107, 197 };
		for (int i = 0; i < data.length; ++i)
			hashTable.add(data[i]);

		for (int i = 1;  i <= maxValue; ++i)
			if (hashTable.contains(i))
				System.out.println(i);
	}
}
