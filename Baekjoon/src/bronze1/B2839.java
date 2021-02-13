package bronze1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B2839 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int five = 0;
		int three = 0;

		// 5로 나눠질 때까지 계속 3을 빼준다.
		while (N % 5 != 0 && N >= 0) {
			N -= 3;
			three++;
		}

		if (N < 0) {
			bw.write(-1 + "\n");
		} else {
			five = N / 5;
			bw.write(five + three + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
