package programmers.정렬;

import java.util.ArrayList;
import java.util.List;

public class 가장큰수 {

	public static String solution(int[] numbers) {
		String answer = "";

		List<String> a = new ArrayList<>(); 
		for(int n : numbers) 
			a.add(String.valueOf(n));

		// 내림차순 정렬 
		a.sort((s1, s2) -> (s2+s1).compareTo(s1+s2));

		for(String s : a) 
			answer += s;

		return answer.charAt(0) == '0' ? "0" : answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {6, 10, 2};
		System.out.println(solution(numbers));

	}

}
