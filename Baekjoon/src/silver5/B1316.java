package silver5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class B1316 {

	public static boolean solution(char[] input) {
		List<Character> list = new ArrayList<>();
		for (int i = 0; i < input.length - 1; ++i) {
			// 앞 문자를 add한 list에 이미 포함되어 있다면 그룹 단어가 아니다.
			if (list.contains(input[i])) {
				return false;
			}

			// 다음 문자와 동일하면 계속 진행
			if (input[i] == input[i + 1]) {
				continue;
			} else { // 붙어있는 문자가 다르면 앞 문자 add
				list.add(input[i]);
			}
		}

		// 마지막 문자까지 list에 없다면 그룹 문자이다.
		return !list.contains(input[input.length - 1]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int cnt = 0;

		for (int i = 0; i < N; ++i) {
			char[] input = br.readLine().toCharArray();
			cnt += solution(input) ? 1 : 0;
		}

		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
		br.close();

	}
}
