package gold5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2493 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Stack<Integer> 탑 = new Stack<>();
		Stack<Integer> index = new Stack<>();

		StringTokenizer t = new StringTokenizer(br.readLine());
		int value = Integer.parseInt(t.nextToken());
		탑.push(value);
		index.push(1);
		System.out.print(0 + " ");

		for (int i = 2; i <= N; i++) {
			value = Integer.parseInt(t.nextToken());
			while (!탑.isEmpty()) {
				if (value < 탑.peek()) {
					System.out.print(index.peek() + " ");
					break;
				}
				탑.pop();
				index.pop();
			}

			if (탑.isEmpty())
				System.out.print(0 + " ");

			탑.push(value);
			index.push(i);

		}

	}

}
