package programmers.practice;

public class 숫자카드게임 {
	public static void main(String[] args) {
		int[][] cards = {{3, 1, 2}, {4, 1, 4}, {2, 2, 2}};

		int result = 0;
		for (int i = 0; i < cards.length; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < cards.length; j++) {
				min = Math.min(min, cards[i][j]);
			}
			result = Math.max(min, result);
		}

		System.out.println(result);
	}
}
