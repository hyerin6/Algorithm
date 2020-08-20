package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B5397_v1 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; ++i) {
			char[] str = br.readLine().toCharArray();

			Stack<Character> stack = new Stack<Character>();
			Stack<Character> tempStack = new Stack<Character>();

			for(int j = 0; j < str.length; ++j) {
				switch(str[j]) {
				case '-':
					if(!stack.isEmpty()) {
						stack.pop();
					}
					break;
				case '<': 
					if(!stack.isEmpty()) {
						tempStack.push(stack.pop());
					}
					break;
				case '>': 
					if(!tempStack.isEmpty()) {
						stack.push(tempStack.pop());
					}
					break;
				default: 
					if(str[j] != '<' && str[j] != '>' && str[j] != '-') {
						stack.push(str[j]);
					}
					break;
				}
			}

			while(!tempStack.isEmpty()) {
				stack.push(tempStack.pop());
			}

			StringBuilder sb = new StringBuilder();
			for(Character c : stack) {
				sb.append(c);
			}

			System.out.println(sb);
		}
	}

}
