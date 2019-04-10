package binaryTree;

/* 연습문제 3) 반복문으로 구현
 * 이진 트리의 add, contains 메소드를, 재귀호출 없이 반복문으로 구현하라.
 */

public class Example5 {

	static class Node {
		int value;
		Node left;
		Node right;

		public Node(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}

		public void print() {
			if (left != null) left.print();
			System.out.printf("%d ", value);
			if (right != null) right.print();
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

	static class BinaryTree {
		Node root;

		public boolean contains(int value) {
			if (root == null) return false;
			Node node = root;
			while (node != null) {
				if (node.value < value) node = node.left;
				else if (node.value > value) node = node.right;
				else return true;
			}
			return false;
		}

		public void add(int value) {
			if(root == null) {
				root = new Node(value);
				return;
			}
			
			Node t = root;
			Node p = null;

			while(t != null) {
				p = t;
				if(value == t.value) return;
				if(value > t.value)
					t = t.right;
				else 
					t = t.left;
			}

			if(p.value > value) p.left = new Node(value);
			else p.right = new Node(value);
			return;
		}

		public void print() {
			if (root != null) root.print();
			System.out.println();
		}

		public void remove(int value) {
			if(root == null) return;
			else if(root.value == value) { // root를 삭제해야 하는 경우
				if(root.left != null && root.right != null) { // 자식이 2개
					int temp = root.right.getLeftMostValue();
					root.value = temp;
					root.right.remove(temp, root);
				} else { // 자식이 하나인 경우
					Node child = (root.left != null) ? root.left : root.right;
					root = child;
				}
			} 
			else 
				root.remove(value, null);
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
		binaryTree.remove(12);
		System.out.println();

		binaryTree.print();
	}
}
