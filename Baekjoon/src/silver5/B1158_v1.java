package silver5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1158_v1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		int m = input.nextInt();

		Queue<Integer> list = new LinkedList<Integer>();
		Queue<Integer> result = new LinkedList<Integer>();

		for (int i = 0; i < n; ++i) {
			list.offer(i + 1);
		}

		int count = 1;
		while (!list.isEmpty()) {
			if (count % m == 0) {
				result.offer(list.poll());
				count++;
				continue;
			}
			list.offer(list.poll());
			count++;
		}

		System.out.print("<" + result.poll());
		while (!result.isEmpty()) {
			System.out.print(", " + result.poll());
		}
		System.out.print(">");

	}

}

