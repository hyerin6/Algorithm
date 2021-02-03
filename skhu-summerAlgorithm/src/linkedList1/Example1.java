package linkedList1;

class Node {
	int value;
	Node next;

	public Node(int value, Node next) {
		this.value = value;
		this.next = next;
	}
}

class LinkedList {
	Node head = null;

	// value를 링크드 리스트 선두에 추가한다.
	public void addHead(int value) {
		head = new Node(value, head);
	}

	// 링크드 리스트에서 value를 찾아서 제거한다
	public void remove(int value) {
		Node node = head; // 현재 노드를 가르키는 변수
		Node prev = null; // 현재 노드의 앞 부모 노드를 가르키는 변수
		while (node != null) {
			if (node.value == value) { // 삭제할 노드 찾기
				if (prev == null) head = head.next; // 삭제할 노드가 head이면
				else prev.next = node.next; // 삭제할 노드가 head가 아니면
				break;
			}
			prev = node;
			node = node.next;
		}
	}

	public void print() {
		Node node = head;
		while (node != null) {
			System.out.printf("%d ", node.value);
			node = node.next;
		}
		System.out.println();
	}
}

public class Example1 {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		for (int i = 0; i < 10; ++i) {
			list.addHead(i);
			list.print();
		}
		for (int i = 1; i < 10; i += 2) {
			list.remove(i);
			list.print();
		}
		for (int i = 0; i < 10; i += 2) {
			list.remove(i);
			list.print();
		}
	}
}