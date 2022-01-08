package silver3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class B17413 {
	static Stack<Character> stack = new Stack<>();
	static StringBuilder sb = new StringBuilder();

	public static void print() {
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		boolean flag = true; // false: 태그, true: 단어

		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) == '<') {
				print();
				sb.append('<');
				flag = false;
				continue;
			}
			if (flag && s.charAt(i) != ' ') {
				stack.push(s.charAt(i));
			}
			if (!flag) {
				sb.append(s.charAt(i));
			}
			if (s.charAt(i) == '>') {
				flag = true;
			}
			if (flag && s.charAt(i) == ' ') {
				print();
				sb.append(s.charAt(i));
			}
		}

		print();
		bw.write(sb.toString() + "\n");
		bw.close();
		br.close();
	}

}
