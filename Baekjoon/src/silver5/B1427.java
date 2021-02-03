package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B1427 {

	public static void solution(List<Integer> list) {
		Collections.sort(list, (i1, i2) -> i2 - i1);

		for (int i = 0; i < list.size(); ++i)
			System.out.printf("%d", list.get(i));
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] strArr = br.readLine().split("");

		List<Integer> list = new ArrayList<>();

		for (String s : strArr)
			list.add(Integer.parseInt(s));

		solution(list);

	}

}
