package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
1번 카드가 제일 위에, N번 카드가 제일 아래인 상태로 순서대로 카드가 놓여 있다.
다음과 같은 동작을 카드가 한 장 남을 때까지 반복하게 된다.
제일 위에 있는 카드를 바닥에 버린다. 그 다음, 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.
 */
public class B2164 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> cards = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; ++i) {
			cards.offer(i); // Queue에 숫자 추가
		}

		while (cards.size() > 1) {
			cards.poll(); // Queue 가장 앞에 있는 카드 빼기
			int card = cards.poll();
			cards.add(card); // Queue 가장 뒤에 card 추가
		}

		System.out.println(cards.poll());
	}
}
