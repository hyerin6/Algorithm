package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class B1181 {

	public static List<String> solution(List<String> list) {

		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length()) // 길이가 같으면 사전 순으로 정렬 
					return s1.compareTo(s2);
				return s1.length() - s2.length();
			}
		});

		List<String> result = new ArrayList<>();

		Iterator<String> it = list.listIterator();

		// 중복된 문자열은 삭제한다. 
		while(it.hasNext()) {
			String s = it.next();
			if(!result.contains(s))
				result.add(s);
		}

		return result;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		List<String> list = new ArrayList<>();

		for(int i = 0; i < n; ++i) 
			list.add(br.readLine());

		for(String s : solution(list))
			System.out.println(s);
	}

}
