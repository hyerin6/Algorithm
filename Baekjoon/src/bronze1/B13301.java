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
		int result = 0;

		if (N == 1) {
			result = 1;
		} else {
			int[] arr = new int[N];
			arr[0] = 1;
			arr[1] = 1;

			int i = 2;
			while (i < N) {
				arr[i] = arr[i - 1] + arr[i - 2];
				++i;
			}

			result = arr[N - 1] * 4 + arr[N - 2] * 2;
		}

		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();

	}
}
