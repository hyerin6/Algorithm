package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B1292 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		List<Integer> list = new ArrayList<>();

		int sum = 0;
		int idx = 0;

		for (int i = 1; idx < B; ++i) {
			idx += i;
			int j = i;
			while (j > 0) {
				list.add(i);
				j--;
			}
		}

		for (int i = A; i <= B; ++i) {
			sum += list.get(i - 1);
		}

		System.out.println(sum);
	}

}
