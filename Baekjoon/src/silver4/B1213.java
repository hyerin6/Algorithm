package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1213 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		int[] cnt = new int[26];

		for (int i = 0; i < str.length(); ++i) {
			cnt[str.charAt(i) - 'A']++;
		}

		int oddCnt = 0;
		int oddIdx = 0;
		for (int i = 0; i < cnt.length; ++i) {
			if (cnt[i] % 2 == 1) {
				oddCnt++;
				oddIdx = i;
			}
		}

		// 길이가 짝수인데 하나만 존재하는 알파벳이 있는 경우
		// 길이가 홀수인데 하나만 존재하는 알파벳이 하나가 아닌 경우
		// 팰리드롬 문자열이 될 수 없다. 
		if ((str.length() % 2 == 0 && oddCnt > 0) || (str.length() % 2 == 1 && oddCnt != 1)) {
			System.out.printf("I'm Sorry Hansoo");
			return;
		}

		for (int i = 0; i < cnt.length; i++) {
			for (int j = 0; j < cnt[i] / 2; j++) { // A부터 알파벳 수 카운팅 배열의 절반씩을 출력한다.
				System.out.printf("%c", i + 'A');
			}
		}

		if (str.length() % 2 == 1) { // 하나만 있는 알파벳이 있으면 중간에 넣어준다.
			System.out.printf("%c", oddIdx + 'A');
		}

		// 나머지 알파벳을 출력해준다.
		for (int i = 25; i >= 0; i--) {
			for (int j = 0; j < cnt[i] / 2; j++) {
				System.out.printf("%c", i + 'A');
			}
		}
	}
}