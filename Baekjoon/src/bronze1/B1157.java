package bronze1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B1157 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine().toUpperCase();
		int[] cnt = new int[26];
		
		int max = 0;
		char result = '?';

		for (int i = 0; i < input.length(); i++) {
			cnt[input.charAt(i) - 65]++;
			if (max < cnt[input.charAt(i) - 65]) {
				max = cnt[input.charAt(i) - 65];
				result = input.charAt(i);
			} else if (max == cnt[input.charAt(i) - 65]) {
				result = '?';
			}
		}

		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();

	}
}
