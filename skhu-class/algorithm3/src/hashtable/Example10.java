package hashtable;

// int 값만 저장하는 해시 테이블은 유용하지 않다.
// 아무 객체나 저장할 수 있는 해시 테이블을 구현하자.

/*
Object 클래스의 hashCode 메소드는 해시 테이블에 저장할 위치를 계산할 때 사용할 해시 값을 리턴한다.
내가 구현한 클래스 객체를 해시 테이블에 넣으려면, 
먼저 hashCode 메소드를 재정의하는 것이 바람직하다.
자료가 해시 테이블에 골고루 분포하려면 hashCode 값이 정확해야 하기 때문이다.
Object 클래스에서 상속받은 hashCode 값은 정확하지 않다.

모든 멤버 변수를 고려해야 해시 값을 계산하여야 한다.

이런 용도로 Objects 클래스의 hash 메소드를 사용하면 된다.
Person 클래스의 모든 멤버 변수를 이 메소드의 파라미터에 나열하면 된다.
 */

public class Example10 {
	static class HashTable {
		static final Object EMPTY = null;
		static final Object DELETED = new Object();
		static final double A = 0.3758;
		static final int[] PRIME_NUMBER = {3, 5, 7, 11, 13, 17, 19 };

		Object[] a;
		int count;
		int threshold;

		public HashTable() {
			this(32);
		}

		public HashTable(int size) {
			this.a = new Object[size];
			this.threshold = (int)(this.a.length * 0.7);
		}

		private void resize() {
			int newSize = a.length * 2;
			HashTable newHashTable = new HashTable(newSize);
			for (Object value : a)
				if (value != EMPTY && value != DELETED)
					newHashTable.add(value);
			this.a = newHashTable.a;
			this.threshold = newHashTable.threshold;
		}

		public void add(Object value) {
			int collisionCount = 0;
			do {
				int index = getIndex(value, collisionCount);
				if (a[index] == EMPTY || a[index] == DELETED) {
					a[index] = value;
					this.count++;
					if (this.count >= this.threshold) resize();
					return;
				} else if (a[index] == value)
					return;
				++collisionCount;
			} while (collisionCount < a.length);
		}

		private int getIndex(Object value, int collisionCount) {
			int startIndex = (int)(((value.hashCode() * A) % 1) * this.a.length);
			int step = PRIME_NUMBER[value.hashCode() % 7];
			return (startIndex + collisionCount * step) % a.length;
		}

		public void remove(int value) {
			int collisionCount = 0;
			do {
				int index = getIndex(value, collisionCount);
				if (a[index] == EMPTY) return;
				else if (a[index].equals(value)) {
					a[index] = DELETED;
					this.count--;
					return;
				}
				++collisionCount;
			} while (collisionCount < a.length);
		}

		public boolean contains(Object value) {
			int collisionCount = 0;
			do {
				int index = getIndex(value, collisionCount);
				if (a[index] == EMPTY) return false;
				else if (a[index] == value) return true;
				++collisionCount;
			} while (collisionCount < a.length);
			return false;
		}
	}

	public static void main(String[] args) throws Exception {
		Person[] a = new Person[] {
				new Person("홍길동", 18),
				new Person("임꺽정", 22),
				new Person("전우치", 23)
		};
		HashTable hashTable = new HashTable();

		for (Person person : a)
			hashTable.add(person);

		for (Person person : a)
			System.out.println(hashTable.contains(person));
		System.out.println(hashTable.contains(new Person("연흥부", 30)));
	}
}
