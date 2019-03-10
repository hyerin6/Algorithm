package algorithm1;

public class Example3 {

	static class Node{
		int value;
		Node next;

		public Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}

		public void printAll() {
			System.out.printf("%d ", this.value);
			if(this.next != null) next.printAll();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = null;

		/* 
		 * 출력 결과가 10, 9, 8, ..., 1인 이유 생각해보기
		 * 계속 root에 새로운 Node를 대입하고 있기 때문에 
		 * 마지막으로 root가 가리키고 있는 것은 10이다. 
		 * 그래서 10부터 출력되는 것이다.
		 */

		for(int i = 1; i <= 10; ++i)
			root = new Node(i, root);

		/* 반복문을 사용한 value 출력
		Node n = root;
		while(n != null) {
			System.out.print(n.value + " ");
			n = n.next;
		}*/

		root.printAll(); // 재귀 호출 

	}

}
