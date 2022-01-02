package programmers.line2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
문자열을 압축한다. RLE(Run Length Encoding) 방법으로, 
문자열을 나타난 횟수만큼 숫자와 문자로 표시한다. 
예를 들어, AAAAAADDC일 때 A는 6개, D는 2개, C는 1개이므로 6A2D1C를 출력한다.
 */
public class Main1 {

	public static String convert(String str) {
		StringBuilder sb = new StringBuilder();
		char prev = 0;
		int count = 0;

		for (int i = 0; i < str.length(); ++i) {
			char c = str.charAt(i);
			if (c == prev) {
				++count;
			} else {
				if (count > 0) {
					sb.append(count).append(prev);
				}
				prev = c;
				count = 1;
			}

		}

		sb.append(count).append(prev);
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; ++i) {
			System.out.println(convert(br.readLine()));
		}

	}

}
