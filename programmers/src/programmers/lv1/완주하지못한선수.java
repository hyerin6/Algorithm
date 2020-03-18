package programmers.lv1;

import java.util.*;
import java.util.Map.Entry;

public class 완주하지못한선수 {

	public static String solution(String[] participant, String[] completion) {
		String answer = "";

		Map<String, Integer> map = new HashMap<>();

		for(String s : participant) 
			map.put(s, map.getOrDefault(s, 0) + 1);

		for(String s : completion) 
			map.put(s, map.get(s)-1);

		for(Entry<String, Integer> entry : map.entrySet()) 
			if(entry.getValue() == 1)
				answer = entry.getKey();

		return answer;
	}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String[] participant = {"leo", "leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki", "leo"};
		System.out.println(solution(participant, completion));
	}

}
