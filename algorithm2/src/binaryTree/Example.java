package binaryTree;

public class Example {

	static class Node {
		int value;
		Node left;
		Node right;

		public Node(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}

		// 이진 탐색 트리는 중복을 허용하지 않기 문에 
		// (value == this.value)인 경우 add 하지 않고 무시한다. 
		public void add(int value) {
			if(this.value > value) {
				if(left == null) 
					left =  new Node(value);
				else left.add(value);
			}else if(this.value < value) {
				if(right == null) 
					right = new Node(value);
				else right.add(value);
			}
		}

		public void print() {
			if(left != null) left.print();
			System.out.printf("%d ", value);
			if(right != null) right.print();
		}

		public boolean contains(int value) {
			if (value < this.value) return left != null && left.contains(value);
			else if (value > this.value) return right != null && right.contains(value);
			return true; // (value == this.value)인 경우 return true;
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = { 5, 18, 1, 12, 7, 2, 14, 6, 9, 15 };
		Node root = new Node(10);

		for (int i = 0; i < a.length; ++i)
			root.add(a[i]);

		root.print();
		System.out.println();

	}

}
