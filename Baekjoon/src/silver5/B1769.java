package silver5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B1769 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String x = br.readLine();

		int cnt = 0;

		while (true) {
			long sum = 0;
			if (x.length() == 1) {
				break;
			}
			for (int i = 0; i < x.length(); i++) {
				sum += Integer.parseInt(String.valueOf(x.charAt(i)));
			}
			cnt++;
			x = String.valueOf(sum);
		}

		if (Integer.parseInt(String.valueOf(x)) % 3 == 0) {
			bw.write(cnt + "\n");
			bw.write("YES" + "\n");
		} else {
			bw.write(cnt + "\n");
			bw.write("NO" + "\n");
		}

		bw.close();
		br.close();
	}
}
