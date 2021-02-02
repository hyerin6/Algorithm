package training;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B1225 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		String A = st.nextToken();
		String B = st.nextToken();
		long sum = 0;

		for (int i = 0; i < A.length(); ++i) {
			for (int j = 0; j < B.length(); ++j) {
				sum += (A.charAt(i) - '0') * (B.charAt(j) - '0');
			}
		}

		bw.write(sum + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
