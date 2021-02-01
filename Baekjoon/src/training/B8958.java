package training;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B8958 {

	private static int quiz(String s) {
		char[] arr = s.toCharArray();
		int cnt = 0;
		int result = 0;

		for (int i = 0; i < arr.length; ++i) {
			if (arr[i] == 'O') {
				cnt++;
				result += cnt;
			} else {
				cnt = 0;
			}
		}

		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; ++i) {
			int result = quiz(br.readLine());
			bw.write(result + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}
}
