package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1543 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		sb.append(br.readLine());
		String str = br.readLine();

		int count = 0;
		int startIndex = 0;
		int len = str.length();

		// 문자열의 맨 처음부터 해당 문자가 포함된 첫 인덱스 + 문자의 길이 만큼 제거
		while ((startIndex = sb.toString().indexOf(str)) != -1) {
			sb.delete(0, startIndex + len);
			count++;
		}

		System.out.println(count);

	}
}
