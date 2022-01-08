package silver2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class B2504 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = br.readLine();

		Stack<Character> stack = new Stack<>();
		int temp = 1;
		int answer = 0;

		if (input.length() % 2 != 1) {

			for (int i = 0; i < input.length(); ++i) {
				if (input.charAt(i) == '(') {
					stack.push('(');
					temp *= 2;
				} else if (input.charAt(i) == '[') {
					stack.push('[');
					temp *= 3;
				} else if (input.charAt(i) == ')') {
					if (stack.isEmpty() || stack.peek() != '(') {
						answer = 0;
						break;
					} else if (input.charAt(i - 1) == '(') {
						answer += temp;
					}
					temp /= 2;
					stack.pop();
				} else if (input.charAt(i) == ']') {
					if (stack.isEmpty() || stack.peek() != '[') {
						answer = 0;
						break;
					} else if (input.charAt(i - 1) == '[') {
						answer += temp;
					}
					temp /= 3;
					stack.pop();
				}
			}
		}
		bw.write(answer + "\n");
		bw.close();
		br.close();
	}
}
