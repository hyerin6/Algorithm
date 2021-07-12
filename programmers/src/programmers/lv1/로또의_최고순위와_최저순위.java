package programmers.lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 로또의_최고순위와_최저순위 {

	/*
	구매한 로또 번호를 담은 배열 lottos,
	당첨 번호를 담은 배열 win_nums
	 */

	static int[] score = {6, 6, 5, 4, 3, 2, 1};

	public static int[] solution(int[] lottos, int[] win_nums) {

		int[] answer = new int[2];

		int[] lottosTemp = new int[46];
		int[] winNumsTemp = new int[46];

		for (int i = 0; i < lottos.length; ++i) {
			if (lottos[i] == 0) {
				lottosTemp[0] += 1;
			} else {
				lottosTemp[lottos[i]] = 1;
			}
			winNumsTemp[win_nums[i]] = 1;
		}

		int eq = 0;
		for (int i = 0; i < lottosTemp.length; ++i) {
			if (lottosTemp[i] == 1 && winNumsTemp[i] == 1) {
				eq++;
			}
		}

		answer[0] = score[eq + lottosTemp[0]];
		answer[1] = score[eq];

		return answer;
	}

	public static int[] solution2(int[] lottos, int[] win_nums) {
		Map<Integer, Boolean> map = new HashMap<>();
		int zeroCount = 0;

		for (int lotto : lottos) {
			if (lotto == 0) {
				zeroCount++;
				continue;
			}
			map.put(lotto, true);
		}

		int sameCount = 0;
		for (int winNum : win_nums) {
			if (map.containsKey(winNum))
				sameCount++;
		}

		int maxRank = 7 - (sameCount + zeroCount);
		int minRank = 7 - sameCount;

		maxRank = maxRank > 6 ? 6 : maxRank;
		minRank = minRank > 6 ? 6 : minRank;

		return new int[] {maxRank, minRank};
	}

	public static void main(String[] args) {
		int[] answer1 = solution(new int[] {44, 1, 0, 0, 31, 25}, new int[] {31, 10, 45, 1, 6, 19});
		System.out.println(Arrays.toString(answer1));

		int[] answer2 = solution(new int[] {0, 0, 0, 0, 0, 0}, new int[] {38, 19, 20, 40, 15, 25});
		System.out.println(Arrays.toString(answer2));

		int[] answer3 = solution(new int[] {45, 4, 35, 20, 3, 9}, new int[] {20, 9, 3, 45, 4, 35});
		System.out.println(Arrays.toString(answer3));
	}
}
