
public class Example1 {
	static class Node { 
		int value; 
		Node left, right; 

		public Node(int value) { this.value = value; } 

		public static Node add(Node n, int value) {
			if (n == null) return new Node(value); 
			if (value < n.value) n.left = add(n.left, value); 
			else if (value > n.value) n.right = add(n.right, value); 
			System.out.printf("%d ", n.value); //(가)
			return n;
		}

		public static void print(Node node) { 
			if (node == null) return; 
			//System.out.print("a");
			print(node.left); 
			//System.out.print("b");
			System.out.printf("%d ", node.value); 
			//System.out.print("c");
			print(node.right); 
			//System.out.print("d");
			System.out.printf("%d ", node.value); 
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node = new Node(5); 
		Node.add(node, 3); 
		int[] a = {7, 6}; 
		for (int i : a) 
			Node.add(node, i); 

		System.out.println();
		Node.print(node); //(나)
	}
}