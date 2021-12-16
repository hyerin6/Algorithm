package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1789 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long S = Long.parseLong(st.nextToken());
		long sum = 0;
		long addNum = 0;
		while (S >= sum) {
			sum += (++addNum);
		}

		if (sum == S) {
			System.out.println(addNum);
		} else {
			System.out.println(addNum - 1);
		}

	}

}
