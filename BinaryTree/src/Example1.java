
public class Example1 {

	static class Node{
		int value;
		Node left;
		Node right;

		public Node(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}

		public void add(int value) {
			if(value < this.value) {
				if(left == null) left = new Node(value);
				else left.add(value);
			} else if(value > this.value) {
				if (right == null) right = new Node(value);
				else right.add(value);
			}
		}

		public static void 탐색1(Node node) {
			

		}


	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 10, 5, 18, 1, 12, 7, 2, 14, 6, 9, 15 };
		Node root = new Node(a[0]);
		for (int i = 1; i < a.length; ++i)
			root.add(a[i]);

		Node.탐색1(root);
		System.out.println();
	}

}
