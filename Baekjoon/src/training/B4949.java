package training;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;

public class B4949 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while(true) {
			String input = br.readLine();

			if(input.equals(".")) { // 종료 조건
				bw.flush();
				bw.close();
				return;
			}

			ArrayDeque<Character> stack = new ArrayDeque<>();
			boolean isVPS = true;

			// 한 글자씩 검사
			for(char c : input.toCharArray()) {
				if(c == '(' || c == '[')
					stack.push(c);
				else if(c == ')') {
					if(stack.isEmpty() || stack.pop() != '(') {
						isVPS = false;
						break;
					}
				} else if(c == ']') {
					if(stack.isEmpty() || stack.pop() != '[') {
						isVPS = false;
						break;
					}
				}
			}

			if(!stack.isEmpty())
				isVPS = false;

			if(isVPS)
				bw.write("yes\n");
			else
				bw.write("no\n");
		}


	}

}
