package programmers.line2018;

// 첫 번째 줄에는 가능한 아르바이트 갯수를 입력
// 두 번째 줄부터는 각각의 아르바이트의 시작 날(M), 기간(D), 보수(I)가 공백을 기준으로 입력
// 각각의 아르바이트는 시작 날을 기준으로 오름차순 정렬되어 있다.
// 브라운이 아르바이트를 수행할 수 있는 기간은 200일이다. (0 <= M <= 200)
// 각각의 아르바이트를 수행할 수 있는 최대 기간은 100이다. (0 <= D <= 100)
// 받을 수 있는 최대 보수는 100이다. (0 <= I <= 100)

import java.util.Stack;

public class Main5_v1 {

	static class Working {
		int start;
		int end;
		int pay;

		public Working(int start, int end, int pay) {
			this.start = start;
			this.end = end;
			this.pay = pay;
		}

		@Override
		public String toString() {
			return String.format("(%d, %d, %d)", start, end, pay);
		}
	}

	static int maxSum = 0;
	static Stack<Working> maxSchedule;

	static void printMaxSchedule() {
		System.out.println(amount(maxSchedule));
		for (Working w : maxSchedule)
			System.out.printf("%d %d\n", w.start, w.pay);
	}

	static boolean isImpossible(Stack<Working> w) {
		if (w.size() <= 1) {
			return false;
		}
		for (int i = 0; i < w.size() - 1; ++i) {
			Working job1 = w.get(i);
			Working job2 = w.get(i + 1);
			if (job1.start + job1.end > job2.start) {
				return true;
			}
		}
		return false;
	}

	static int amount(Stack<Working> schedule) {
		int sum = 0;
		for (Working w : schedule) {
			sum += w.pay;
		}
		return sum;
	}

	static void schedule(Working[] w, Stack<Working> schedule, int index) {
		if (isImpossible(schedule)) {
			return;
		}
		if (index >= w.length) {
			int t = amount(schedule);
			if (t > maxSum) {
				maxSum = t;
				maxSchedule = (Stack<Working>)schedule.clone();
			}
			return;
		}
		schedule.push(w[index]);
		schedule(w, schedule, index + 1);
		schedule.pop();
		schedule(w, schedule, index + 1);
	}

	public static void main(String[] args) {
		int N = 5;
		Working[] input = {
			new Working(0, 4, 5),
			new Working(3, 4, 20),
			new Working(6, 6, 3),
			new Working(8, 5, 35),
			new Working(10, 4, 12)
		};

		schedule(input, new Stack<Working>(), 0);
		printMaxSchedule();
	}
}
