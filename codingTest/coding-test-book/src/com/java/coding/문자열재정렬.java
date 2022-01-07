package com.java.coding;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class 문자열재정렬 {

	public static ArrayList<Character> result = new ArrayList<>();

	public static void solution(String s) {
		int sum = 0;
		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) < 48 || s.charAt(i) > 58) {
				result.add(s.charAt(i));
			} else {
				sum += s.charAt(i) - '0';
			}
		}

		Collections.sort(result);

		for (int i = 0; i < result.size(); ++i) {
			System.out.print(result.get(i));
		}

		// 숫자가 하나라도 존재하는 경우 가장 뒤에 출력
		if (sum != 0) {
			System.out.println(sum);
		}

	}

	public static void main(String[] args) throws IOException {
		solution("K1KA5CB7");
	}
}
