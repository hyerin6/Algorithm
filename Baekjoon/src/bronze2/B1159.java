package bronze2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class B1159 {

	private static void solution1() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> cnt = new HashMap<>();

		for (int i = 0; i < N; ++i) {
			String s = br.readLine().substring(0, 1);
			if (cnt.containsKey(s)) {
				cnt.put(s, cnt.get(s) + 1);
			} else {
				cnt.put(s, 1);
			}
		}

		for (Map.Entry<String, Integer> elem : cnt.entrySet()) {
			if (elem.getValue() >= 5) {
				sb.append(elem.getKey());
			}
		}

		System.out.println(sb.length() == 0 ? "PREDAJA" : sb.toString());
	}

	private static void solution2() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] alpha = new int[26];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			alpha[line.charAt(0) - 'a']++; // alpha[line.charAt(0) - 97]++;
		}

		boolean chk = false;
		for (int i = 0; i < 26; i++) {
			if (alpha[i] >= 5) {
				chk = true;
				bw.write((char)(i + 'a')); // bw.write((char)(i + 97));
			}
		}

		if (!chk) {
			bw.write("PREDAJA\n");
		} else {
			bw.write("\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}

	public static void main(String[] args) throws IOException {
		solution2();
	}

}
