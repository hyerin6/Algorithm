package bronze1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B13301 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		long[] fibo = new long[3];
		fibo[0] = 1;
		fibo[1] = 1;
		fibo[2] = 1;

		for (int i = 2; i <= N; i++) {
			fibo[2] = fibo[0] + fibo[1];
			fibo[0] = fibo[1];
			fibo[1] = fibo[2];
		}

		bw.write(2 * (fibo[0] + fibo[1]) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
