package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B17427 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		long answer = 0;

		/*
		n 이하인 수들 중에서 i를 약수로 갖는 수
		=> n 이하의 i의 배수
		=> 개수를 구하려면 n/i 이다.
		*/
		for (int i = 1; i <= n; ++i) {
			answer += i * (n / i); // i를 약수로 갖는 수가 n/i 만큼 있다.
		}

		System.out.println(answer);
	}

}
