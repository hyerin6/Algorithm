package bronze1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B1032 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		String[] input = new String[n];

		for (int i = 0; i < n; ++i) {
			input[i] = br.readLine();
		}

		boolean[] answer = new boolean[input[0].length()];

		for (int i = 0; i < input[0].length(); ++i) {
			for (int j = 1; j < input.length; ++j) {
				if (input[j - 1].charAt(i) != input[j].charAt(i)) {
					answer[i] = true;
					break;
				}
			}
		}

		for (int i = 0; i < input[0].length(); i++) {
			if (answer[i]) { // 다른 파일과 이름이 다른 것
				bw.write("?");
			} else {
				bw.write(input[0].charAt(i));
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
