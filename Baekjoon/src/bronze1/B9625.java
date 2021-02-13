package bronze1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B9625 {

	/*
	A -> B -> BA -> BAB -> BABBA -> BABBABAB
	[B -> BA, A -> B]

	k=n A, B
	k=0 1, 0
	k=1 0, 1
	k=2 1, 1
	k=3 1, 2
	k=4 2, 3
	k=5 3, 5
	...
	k=n arr[n-1][1], arr[n-1][0]+arr[n-1][1]
	*/

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int K = Integer.parseInt(br.readLine());

		int[][] arr = new int[K][2];
		arr[0][0] = 0;
		arr[0][1] = 1;

		int i = 1;
		while (i < K) {
			arr[i][0] = arr[i - 1][1];
			arr[i][1] = arr[i - 1][0] + arr[i - 1][1];
			++i;
		}

		bw.write(arr[K - 1][0] + " " + arr[K - 1][1] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
