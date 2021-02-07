package bronze1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B2748 {

	static long[] arr;

	private static long fibo(int n) {
		if (arr[n] == -1) {
			arr[n] = fibo(n - 1) + fibo(n - 2);
		}
		return arr[n];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		arr = new long[n + 1];

		for (int i = 0; i < n + 1; ++i) {
			arr[i] = -1;
		}

		arr[0] = 0;
		arr[1] = 1;

		bw.write(fibo(n) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
