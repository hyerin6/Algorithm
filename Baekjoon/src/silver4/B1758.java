package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class B1758 {

	// 강호에게 원래 주려고 생각했던 돈 - (받은 등수 - 1) 만큼의 팁을 강호에게 준다.
	// 만약, 위의 식으로 나온 값이 음수라면, 강호는 팁을 받을 수 없다.
	// 손님의 순서를 적절히 바꿨을 때, 강호가 받을 수 잇는 팁의 최댓값

	// N과 팁은 100,000 이하의 수이다.
	// 따라서 int의 범위를 벗어나기에 tip 변수의 자료형을 long으로 선언해야 한다.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Integer[] tips = new Integer[N];
		long answer = 0;

		for (int i = 0; i < N; ++i) {
			tips[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(tips, Collections.reverseOrder());

		for (int i = 1; i <= N; ++i) {
			int m = tips[i - 1] - (i - 1);
			answer += m > 0 ? m : 0;
		}

		System.out.println(answer);
	}
}
