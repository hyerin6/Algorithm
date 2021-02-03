package net.skhu.recursive;

public class Example4 {

	static class Node {
		int value;
		Node next;

		public Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}

		public void printAll() {
			System.out.printf("%d ", this.value);
			if (next != null) next.printAll();
		}

		/**
		 * addTail 메소드는 링크드 리스트 끝에 value 값의 Node를 추가한다. 
		 * 
		 * @param value
		 */
		public void addTail(int value) {
			if (next == null) next = new Node(value, null);
			else next.addTail(value);
		}
	}

	public static void main(String[] args) {
		Node root = new Node(0, null);

		for (int i = 1; i <= 10; ++i)
			root.addTail(i);

		root.printAll();
	}
}
