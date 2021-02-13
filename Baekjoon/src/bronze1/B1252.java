package bronze1;

import java.util.Scanner;

public class B1252 {

	/*
	이진수 A, B 를 입력받은 후 편의상 A가 B보다 무조건 더 길도록 했다.
	B의 앞부분에는 A와 길이가 맞게끔 0을 채워주고 합연산을 진행한다.
	결과가 0일때만 0을 출력하고 나머지 경우에는 1로 시작해야 하므로 이부분만 따로 예외처리
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String t1 = sc.next();
		String t2 = sc.next();

		if (t1.length() < t2.length()) {
			String temp = t1;
			t1 = t2;
			t2 = temp;
		}

		int diff = t1.length() - t2.length();
		while (diff-- > 0) {
			t2 = "0" + t2;
		}

		char a[] = t1.toCharArray();
		char b[] = t2.toCharArray();

		int h = 0;
		String s = "";
		for (int i = a.length - 1; i >= 0; i--) {
			int sum = (a[i] - '0') + (b[i] - '0') + h;
			if (sum == 3) {
				s = 1 + s;
				h = 1;
			} else if (sum == 2) {
				s = 0 + s;
				h = 1;
			} else if (sum == 1) {
				s = 1 + s;
				h = 0;
			} else {
				s = 0 + s;
				h = 0;
			}
		}

		s = h == 1 ? h + s : s;
		String ans = "";
		boolean one = true;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1')
				one = false;
			if (one)
				continue;
			ans += s.charAt(i);
		}

		System.out.println(ans.equals("") ? 0 : ans);
	}
}
