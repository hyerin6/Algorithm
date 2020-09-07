package programmers.lv1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 문자열_내맘대로_정렬 {

	public static String[] solution(String[] strings, int n) {
		String[] answer = new String[strings.length];

		List<String> words = new ArrayList<>();
		for(String s : strings) {
			words.add(s);
		}

		Collections.sort(words);
		words.sort((w1, w2) -> w1.substring(n, n+1).compareTo(w2.substring(n, n+1)));

		for(int i = 0; i < strings.length; ++i) {
			answer[i] = words.get(i);
		}

		return answer;
	}

	public static void print(String[] answer) {
		System.out.print("[");
		for(int i = 0; i < answer.length; ++i) {
			if(i < answer.length-1) System.out.printf("\"%s\", ", answer[i]);
			else System.out.printf("\"%s\"", answer[i]);
		}
		System.out.println("]");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strings1 = {"sun", "bed", "car"};
		String[] strings2 = {"abce", "abcd", "cdx"};

		print(solution(strings1, 1));
		print(solution(strings2, 2));
	}

}
