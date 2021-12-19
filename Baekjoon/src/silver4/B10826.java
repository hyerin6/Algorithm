package silver4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class B10826 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		BigInteger fibonacci[] = new BigInteger[N + 3];
		fibonacci[0] = BigInteger.ZERO;
		fibonacci[1] = BigInteger.ONE;

		for (int i = 2; i <= N; i++) {
			fibonacci[i] = fibonacci[i - 1].add(fibonacci[i - 2]);
		}
		
		bw.write(fibonacci[N] + "");
		bw.flush();
	}

}
