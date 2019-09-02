package binaryTree;

/* 연습문제 1) dummy 노드를 활용하여 이진트리 구현
 * 구현#1 예제에서, BinaryTree 클래스의 remove 메소드를 호출할 때마다 
 * dummy 노드를 생성하는 것이 약간 비효율적이다.
 * 이 문제를 개선해 보자. 
 * 
 * BinaryTree가 비어있는 상태일 때 부터, dummy 노드를 한 개 생성하고, 계속 유지하자.
 * dummy 노드의 left 멤버 변수가 root 노드를 가르키도록 하자.
 */

public class Example3 {
	static class Node {
		int value;
		Node left;
		Node right;

		public Node(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}

		public void add(int value) {
			if (value < this.value) {
				if (left == null) left = new Node(value);
				else left.add(value);
			} else if (value > this.value) {
				if (right == null) right = new Node(value);
				else right.add(value);
			}
		}

		public void print() {
			if (left != null) left.print();
			System.out.printf("%d ", value);
			if (right != null) right.print();
		}

		public boolean contains(int value) {
			if (value < this.value) return left != null && left.contains(value);
			else if (value > this.value) return right != null && right.contains(value);
			return true;
		}

		public int getLeftMostValue() {
			if (this.left != null) return this.left.getLeftMostValue();
			return this.value;
		}

		public void remove(int value, Node parent) {
			if (value < this.value) {
				if (left != null) left.remove(value, this);
			} else if (value > this.value) {
				if (right != null) right.remove(value, this);
			} else {
				if (left != null && right != null) {
					int temp = right.getLeftMostValue();
					this.value = temp;
					right.remove(temp, this);
				} else {
					Node child = (left != null) ? left : right;
					if (parent.left == this) parent.left = child;
					else parent.right = child;
				}
			}
		}
	}

	// dummy의 left가 root이기 때문에 코드가 바뀐 부분을 잘 체크하자. 
	static class BinaryTree {
		Node dummy;

		public BinaryTree() {
			dummy = new Node(Integer.MAX_VALUE); 
		}

		public void add(int value) {
			dummy.add(value);
		}	

		public void print() {
			if (dummy.left != null) dummy.left.print();
			System.out.println();
		}

		public boolean contains(int value) {
			return dummy.left != null && dummy.left.contains(value);
		}

		public void remove(int value) {
			if (dummy.left != null) 
				dummy.left.remove(value, dummy);
		}
	}

	public static void main(String[] args) {
		int[] a = { 5, 18, 1, 12, 7, 2, 14, 6, 9, 15 };
		BinaryTree binaryTree = new BinaryTree();
		for (int i = 0; i < a.length; ++i)
			binaryTree.add(a[i]);
		binaryTree.print();
		binaryTree.remove(14);
		binaryTree.remove(15);
		binaryTree.remove(5);
		binaryTree.remove(10);
		System.out.println();

		binaryTree.print();
	}
}
