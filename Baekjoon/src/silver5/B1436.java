package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1436 {

	// 1씩 증가시켜 666이 포함되는지 여부를 계속 검사
	public static void solution(int N) {
		int num = 666;
		int count = 1;
		while (count != N) {
			num++;
			if (String.valueOf(num).contains("666")) {
				count++;
			}
		}
		System.out.println(num);
	}

	// 666, 1666, 2666, ..., 6660, 6661, 6662, ..., 16660, 16661, 16662, ...
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		solution(N);
		br.close();
	}
}
