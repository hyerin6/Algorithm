package silver5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B1251 {

	public static String split(String str, int i, int j, int len) {
		StringBuilder sb = new StringBuilder();
		sb.append(reverse(str.substring(0, i + 1)));
		sb.append(reverse(str.substring(i + 1, j + 1)));
		sb.append(reverse(str.substring(j + 1, len + 1)));
		return sb.toString();
	}

	public static StringBuilder reverse(String s) {
		return new StringBuilder(s).reverse();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		int len = str.length();

		String res = split(str, 0, 1, len - 1);

		for (int i = 0; i < len - 2; ++i) {
			for (int j = i + 1; j < len - 1; ++j) {
				String tmp = split(str, i, j, len - 1);
				if (res.compareTo(tmp) > 0) {
					res = tmp;
				}
			}
		}

		bw.write(res + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
