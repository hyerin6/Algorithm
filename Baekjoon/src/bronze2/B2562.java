package bronze2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B2562 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int max = Integer.parseInt(br.readLine());
		int idx = 1;

		for (int i = 2; i < 10; ++i) {
			int n = Integer.parseInt(br.readLine());
			if (n > max) {
				idx = i;
				max = n;
			}
		}

		bw.write(max + "\n" + idx);
		bw.flush();
		bw.close();
		br.close();
	}
}
