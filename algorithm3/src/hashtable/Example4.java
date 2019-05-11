package hashtable;

public class Example4 {

	// 충돌이 발생하면 바로 뒤에 add
	static class HashTable {
		static final int EMPTY = 0;
		static final int SIZE = 37;
		int[] a;

		public HashTable() {
			a = new int[SIZE];
		}

		public void add(int value) throws Exception {
			int startIndex = value % SIZE; // 저장할 위치 계산
			int count = 0;                 // 충돌 횟수
			do {
				int index = (startIndex + count) % SIZE;	// 저장할 위치 계산
				if (a[index] == EMPTY || a[index] == -1) {	// 빈 칸이면
					a[index] = value;                    	// 저장하고 리턴
					return;
				} else if (a[index] == value) return; // 이미 그 값이 들어있으면 그냥 리턴
				++count;                     // 여기까지 왔으면, 충돌이 일어난 상황. 충돌 횟수 증가
			} while (count < a.length);      // 충돌 횟수가 배열의 크기보다 크거나 같으면 작업 실패
			throw new Exception("공간 부족");
		}

		// remove 메소드를 구현하라.
		// 삭제 후 그 칸을 빈 칸으로 표시하면 안됨. 삭제된 칸으로 표시해야 함.
		// add, contains 메소드에서도 -1 값을 고려해야 한다.
		public void remove(int value) {
			int startIndex = value % SIZE;
			int count = 0;
			do {
				int index = (startIndex + count) % SIZE;
				if (a[index] == EMPTY) return;
				else if (a[index] == value) {
					a[index] = -1;
					return;
				}
				++count;
			} while(count < a.length);
		}

		public boolean contains(int value) {
			int startIndex = value % SIZE; // 저장할 위치 계산
			int count = 0;                 // 충돌 횟수
			do {
				int index = (startIndex + count) % SIZE; // 저장할 위치 계산
				if (a[index] == EMPTY || a[index] == -1) return false;      // 빈 칸이면 그 값이 해시 테이블에 없음.
				else if (a[index] == value) return true;  // 찾았음.
				++count;                  // 여기까지 왔으면, 충돌이 일어난 상황. 충돌 횟수 증가
			} while (count < a.length);   // 충돌 횟수가 배열의 크기보다 크거나 같으면 작업 실패
			return false;
		}
	}

	public static void main(String[] args) throws Exception {
		int maxValue = 200, maxCount = 10;
		HashTable hashTable = new HashTable();

		int[] data = { 4, 13, 144, 7, 9, 11, 44, 115, 107, 196 };
		for (int i = 0; i < data.length; ++i)
			hashTable.add(data[i]);

		for (int i = 1;  i <= maxValue; ++i)
			if (hashTable.contains(i))
				System.out.println(i);
	}
}
