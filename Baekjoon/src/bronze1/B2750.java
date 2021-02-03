package bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		/*
		  문제 조건: 절댓값이 1,000보다 작거나 같은 정수
		  range: -1000 ~ 1000
		  0 은 index[1000] 을 의미
		*/
		boolean[] arr = new boolean[2001];

		for (int i = 0; i < N; i++) {
			arr[Integer.parseInt(br.readLine()) + 1000] = true;
		}

		// 정렬 과정이 따로 필요없다.
		for (int i = 0; i < 2001; i++) {
			if (arr[i]) {
				System.out.println(i - 1000);
			}
		}

	}

}
