package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2693 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int[] A = new int[10];
			for (int i = 0; i < A.length; ++i) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(A);
			System.out.println(A[7]);
		}

	}

}
