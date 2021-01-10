package programmers.lv2;

import java.util.HashMap;
import java.util.Map;

public class 위장 {

	public static int solution(String[][] clothes) {
		int answer = 1;
		Map<String, Integer> clothesCnt = new HashMap<>();

		for(int i = 0; i < clothes.length; ++i) {
			if(!clothesCnt.containsKey(clothes[i][1])) {
				clothesCnt.put(clothes[i][1], 1);
			} else {
				clothesCnt.put(clothes[i][1], clothesCnt.get(clothes[i][1])+1);
			}
		}

		for (String key : clothesCnt.keySet()) {
			int value = clothesCnt.get(key);
			answer *= value+1;
		}

		return answer-1;
	}

	public static void main(String[] args) {
		String[][] s = {
			{"yellow_hat", "headgear"},
			{"blue_sunglasses", "eyewear"},
			{"green_turban", "headgear"}};

		System.out.println(solution(s));

	}

}
