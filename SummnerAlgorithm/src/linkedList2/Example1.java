package linkedList2;

class Node {
	int value;
	Node next;

	public Node(int value, Node next) {
		this.value = value;
		this.next = next;
	}
}

class LinkedList {
	Node dummy = new Node(-1, null);

	// value를 링크드 리스트 선두에 추가한다.
	public void addHead(int value) {
		dummy.next = new Node(value, dummy.next);
	}

	// 링크드 리스트에서 value를 찾아서 제거한다
	public void remove(int value) {
		Node node = dummy.next; // 현재 노드를 가르키는 변수
		Node prev = dummy; // 현재 노드의 앞 부모 노드를 가르키는 변수
		while (node != null) {
			if (node.value == value) { // 삭제할 노드 찾기
				prev.next = node.next;
				break;
			}
			prev = node;
			node = node.next;
		}
	}

	public void print() {
		Node node = dummy.next;
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
