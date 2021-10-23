package programmers.lv2;

import java.util.ArrayList;

public class 뉴스_클러스터링 {

	public static int solution(String str1, String str2) {
		str1 = str1.toUpperCase();
		str2 = str2.toUpperCase();

		ArrayList<String> list1 = new ArrayList<>();
		ArrayList<String> list2 = new ArrayList<>();
		ArrayList<String> union = new ArrayList<>();
		ArrayList<String> intersection = new ArrayList<>();

		for (int i = 0; i < str1.length() - 1; i++) {
			char a = str1.charAt(i);
			char b = str1.charAt(i + 1);
			if (Character.isLetter(a) && Character.isLetter(b)) {
				list1.add(a + "" + b);
			}
		}

		for (int i = 0; i < str2.length() - 1; i++) {
			char a = str2.charAt(i);
			char b = str2.charAt(i + 1);
			if (Character.isLetter(a) && Character.isLetter(b)) {
				list2.add(a + "" + b);
			}
		}

		for (String s : list1) {
			if (list2.remove(s)) { // 집합1에 집합2가 포함된다면 삭제후, 교집합에 추가
				intersection.add(s);
			}
			union.add(s);
		}
		union.addAll(list2);

		if (union.size() == 0) {
			return 65536;
		}

		return (int)((double)intersection.size() / union.size() * 65536);
	}

	public static void main(String[] args) {
		String s1 = "FRANCE";
		String s2 = "french";
		System.out.println(solution(s1, s2));
	}
}
