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

		public void add(int value) {
			// 반복문 구현
		}

		public void print() {
			if(left != null) left.print();
			System.out.printf("%d ", value);
			if(right != null) right.print();
		}

		public boolean contains(int value) {
			// 반복문 구현
			return false;
		}

		public int getLeftMostValue() {
			if(this.left != null) 
				return this.left.getLeftMostValue();
			return this.value;
		}

		public void remove(int value, Node parent) {
			if(value < this.value) { 								// remove하고 싶은 값이 현재 노드 보다 작으면 	
				if(left != null) left.remove(value, this);			// 왼쪽 서브 트리에서 remove()
			}else if(value > this.value) {							// remove하고 싶은 값이 현재 노드 보다 크면
				if(right != null) right.remove(value, this);		// 오른쪽 서브 트리에서 remove()
			}else { 												// value 값이 this.value와 같은 경우에 이 코드가 실행된다.
				if (left != null && right != null) {				// this를 삭제해야 한다.
					int temp = right.getLeftMostValue();			// this.value 다음으로 큰 값을 찾는다. 
					this.value = temp;								// 그 값을 this.value에 대입한다.
					right.remove(temp, this);						// 그 값의 노드를 오른쪽 서브트리에서 remove 한다. (재귀 호출)
				}else {												// this 노드에 적어도 자식이 하나 없는 경우 실행
					Node child = (left != null) ? left : right;		// left, right 중 null이 아닌 값을 child 변수에 대입, 둘 다 null 이라면 child 변수에 null을 대입
					if (parent.left == this) parent.left = child;	// this 노드가 parent의 left 자식이라면, parent.left = child;
					else parent.right = child;						// this 노드가 parent의 right 자식이라면, parent.right = child;
				}
			}
		}
	}
	static class BinaryTree {
		Node root;
		public void add(int value) {
			if (root != null) root.add(value);
			else root = new Node(value);
		}	

		public void print() {
			if (root != null) root.print();
			System.out.println();
		}

		public boolean contains(int value) {
			return root != null && root.contains(value);
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
		binaryTree.remove(10);
		System.out.println();

		binaryTree.print();
	}
}
