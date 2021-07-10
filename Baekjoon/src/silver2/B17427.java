package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B17427 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		long answer = 0; //

		/*
		n/i 는 약수에 몇번 포함되는지를 의미
		i 숫자가 n/i 만큼 포함되기 때문에 곱해서 더해준다.
		*/
		for (int i = 1; i <= n; ++i) {
			answer += i * (n / i);
		}

		System.out.println(answer);
	}

}
