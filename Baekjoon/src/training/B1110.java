package training;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B1110 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int copy = N;
		int cnt = 0;

		do {
			// (N % 10) * 10 = 십의 자리수
			// (N / 10 + N % 10) % 10 = 일의 자리수
			N = ((N % 10) * 10) + (((N / 10) + (N % 10)) % 10);
			cnt++;
		} while (copy != N);

		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
