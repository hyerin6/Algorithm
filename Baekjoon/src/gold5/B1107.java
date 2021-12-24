package gold5;

import java.io.IOException;
import java.util.Scanner;

/*
버튼이 0부터 9까지 숫자, +와 -가 있다.
+를 누르면 현재 보고있는 채널에서 +1된 채널로 이동하고, -를 누르면 -1된 채널로 이동한다.
채널 0에서 -를 누른 경우에는 채널이 변하지 않고, 채널은 무한대 만큼 있다.
 */
public class B1107 {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);

		int target = scan.nextInt();
		int m = scan.nextInt();

		boolean[] broken = new boolean[10];
		for (int i = 0; i < m; i++) {
			int n = scan.nextInt();
			broken[n] = true;
		}

		int result = Math.abs(target - 100); // 초기값 설정 (+, - 버튼만 사용하는 경우)
		for (int i = 0; i <= 999999; i++) {
			String str = String.valueOf(i);
			int len = str.length();

			boolean isBreak = false;
			for (int j = 0; j < len; j++) {
				if (broken[str.charAt(j) - '0']) { // 고장난 버튼을 눌러야 하면
					isBreak = true;
					break; // 더 이상 탐색하지 않고 빠져나온다.
				}
			}
			if (!isBreak) { // i를 누를때 고장난 버튼을 누르지 않는다면
				int min = Math.abs(target - i) + len; // i를 누른 후(len) target까지 이동하는 횟수(target - i)
				result = Math.min(min, result);
			}
		}
		System.out.println(result);
	}

}
