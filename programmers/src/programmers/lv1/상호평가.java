package programmers.lv1;

class Solution {

	public String solution(int[][] scores) {
		String answer = "";

		for (int i = 0; i < scores.length; i++) {
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			int sum = 0;
			int divide = scores.length;
			for (int j = 0; j < scores.length; j++) {
				int score = scores[j][i];
				// 자기가 채점한게 아니면 sum에 더하고 최저, 최고점인지 체크
				if (i != j) {
					if (score < min) {
						min = score;
					}
					if (score > max) {
						max = score;
					}
				}
				sum += score;
			}

			// 자기가 채점한 점수가 최저, 최고점이면 빼고 평균을 구한다.
			if (scores[i][i] < min || scores[i][i] > max) {
				sum -= scores[i][i];
				divide--;
			}

			double score = (double)sum / divide;
			answer += getRank(score);
		}

		return answer;
	}

	public static String getRank(double score) {
		if (score >= 90) {
			return "A";
		}
		if (score >= 80) {
			return "B";
		}
		if (score >= 70) {
			return "C";
		}
		if (score >= 50) {
			return "D";
		}
		return "F";
	}
}

public class 상호평가 {

	public static void main(String[] args) {
		int[][] s = {
			{100, 90, 98, 88, 65},
			{50, 45, 99, 85, 77},
			{47, 88, 95, 80, 67},
			{61, 57, 100, 80, 65},
			{24, 90, 94, 75, 65}};

		Solution solution = new Solution();
		String result = solution.solution(s);
		System.out.println(result);
	}
}
