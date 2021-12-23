package gold5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class B5430 {

	public static StringBuilder sb = new StringBuilder();

	public static void AC(String command, ArrayDeque<Integer> deque) {
		boolean isRight = true;

		for (char cmd : command.toCharArray()) {
			if (cmd == 'R') {
				isRight = !isRight; // 방향을 바꿔준다.
				continue;
			}

			if (isRight) {
				if (deque.pollFirst() == null) {
					sb.append("error\n");
					return;
				}
			} else {
				if (deque.pollLast() == null) {
					sb.append("error\n");
					return;
				}
			}
		}

		makePrintString(deque, isRight);
	}

	public static void makePrintString(ArrayDeque<Integer> deque, boolean isRight) {
		sb.append('[');

		if (deque.size() > 0) {
			if (isRight) {
				sb.append(deque.pollFirst());
				while (!deque.isEmpty()) {
					sb.append(',').append(deque.pollFirst());
				}
			} else {
				sb.append(deque.pollLast());
				while (!deque.isEmpty()) {
					sb.append(',').append(deque.pollLast());
				}
			}
		}

		sb.append(']').append('\n');
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			ArrayDeque<Integer> deque = new ArrayDeque<>();
			String command = br.readLine();
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
			// 덱에 배열 원소를 넣어준다.
			for (int i = 0; i < n; i++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}

			AC(command, deque);
		}

		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
