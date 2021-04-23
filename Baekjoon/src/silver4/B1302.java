package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class B1302 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Map<String, Integer> count = new HashMap<>();
		int max = Integer.MIN_VALUE;
		List<String> answer = new ArrayList<>();

		for (int i = 0; i < N; ++i) {
			String book = br.readLine();
			count.put(book, count.getOrDefault(book, 0) + 1);
			if (max < count.get(book)) {
				answer.clear();
				max = count.get(book);
				answer.add(book);
			}
			if (max == count.get(book) && !answer.contains(book)) {
				answer.add(book);
			}
		}

		Collections.sort(answer);
		System.out.println(answer.get(0));
	}
}
