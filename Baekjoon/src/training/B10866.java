package training;

import java.util.Deque;

// 정수를 저장하는 덱(Deque) 
public class B10866 {
	static class Deque {
		int[] a;
		int front = 0, back = 0, count = 0;

		public Deque(int size) { this.a = new int[size]; }

		public boolean isEmpty() { return count == 0; }

		public int count() { return count; }

		public int front() { 
			if (count == 0) return -1; 
			return a[front]; 
		}

		public void pushBack(int value) { 
			if (count == a.length) expand();
		}

		public void pushFront(int x) {
			if(count == 0) expand();
		}

		public void expand() {
			int size = a.length * 2;
			int[] b = new int[size];

			for(int i = 0; i < count; ++i) {
				int index = (front + i) % a.length;
				b[i] = a[index];
			}
			a = b;
			front = 0;
			back = count;
		}

	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deque queue = new Deque(10);

	}

}
