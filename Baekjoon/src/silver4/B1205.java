package silver4;

import java.util.Scanner;

public class B1205 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = Integer.parseInt(sc.next());
		int score = Integer.parseInt(sc.next());
		int P = Integer.parseInt(sc.next());

		int[] rank = new int[P];
		for (int i = 0; i < N; ++i) {
			rank[i] = Integer.parseInt(sc.next());
		}

		if (N == 0) {
			System.out.println("1");
			return;
		}

		for (int i = 0; i < N; i++) {
			// 랭킹에 있는 점수와 같거나 큰 경우
			if (rank[i] <= score) {
				if (rank[i] == score && N == P) { // 랭킹이 Full인데 유진의 점수가 랭킹에 있는 수와 같은 경우
					boolean flag = true;
					// 꽉 차 있는 리스트 [3 3 3]이면서 X = 3인 경우에도 진입을 하지 못한다.
					for (int temp = i + 1; temp < N; ++temp) {
						if (rank[i] > rank[temp]) { // 랭킹에서 입력 점수보다 작은 점수가 있으면 중간에 진입 가능
							flag = false;
							break;
						}
					}
					if (flag) { // 랭킹에 입력 점수보다 작은 점수가 없어 진입에 실패
						System.out.println("-1");
						return;
					}
				}
				// 진입한 경우 인덱스+1
				System.out.println(i + 1);
				return;
			}

		}

		// 꽉찬 리스트가 아닌 기존 리스트 중간에 진입하지 못하면 마지막 랭킹 점수가 된다.
		if (N < P) {
			System.out.println(N + 1);
			return;
		}

		// 그 외의 경우 = 랭킹 진입에 실패한 경우
		System.out.println("-1");
	}
}