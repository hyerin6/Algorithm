package binaryTree;

import java.util.Random;
// 이진 탐색 트리 : 탐색, 삽입, 삭제 전부 평균 시간 복잡도 o(log n) 
// (편향이진트리)최악인 전체 노드의 개수가 n개일 때, 모든 노드가 자식을 한 개씩만 가지고 있다면 o(n)
public class Example1 {

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
			if(this.value > value) {
				if(left == null) return false;
				left.contains(value);
			} else if(this.value < value) {
				if(right == null) return false;
				right.contains(value);
			}
			return true;
		}
	}

	public static void main(String[] args) {
		Random random = new Random();
		Node root = new Node(random.nextInt(20));
		for (int i = 0; i < 15; ++i)
			root.add(random.nextInt(20));

		root.print();
		System.out.println();

		for (int i = 0; i < 20; ++i) {
			int value = random.nextInt(20);
			System.out.printf("%d %s\n", value, root.contains(value));
		}

	}

}
