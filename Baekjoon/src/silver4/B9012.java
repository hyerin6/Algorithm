package silver4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class B9012 {

	public static void solution(String[] strArr) {

		for (int i = 0; i < strArr.length; ++i) {
			ArrayDeque<Character> stack = new ArrayDeque<>();
			boolean isVPS = true;

			for (int j = 0; j < strArr[i].length(); ++j) {
				char c = strArr[i].charAt(j);

				if (c == '(') {
					stack.push(c);
				} else if (c == ')') {
					if (!stack.isEmpty()) {
						stack.pop();
					} else {
						isVPS = false;
						break;
					}
				}
			}
			if (!stack.isEmpty())
				isVPS = false;

			if (isVPS)
				System.out.println("YES");
			else
				System.out.println("NO");
		}

	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		String[] strArr = new String[N];

		for (int i = 0; i < N; ++i)
			strArr[i] = br.readLine();

		solution(strArr);
	}

}
