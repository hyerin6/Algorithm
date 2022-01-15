package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B2564 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int store = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		int total = (row + col) * 2;

		for (int i = 0; i < store + 1; ++i) {
			st = new StringTokenizer(br.readLine());
			int direction = Integer.parseInt(st.nextToken());
			int position = Integer.parseInt(st.nextToken());
			switch (direction) {
				case 1:
					list.add(position);
					break;
				case 2:
					list.add(row + col + (row - position));
					break;
				case 3:
					list.add(2 * row + col + (col - position));
					break;
				default:
					list.add(row + position);
					break;
			}
		}

		int len = list.get(list.size() - 1);
		int answer = 0;
		for (int i = 0; i < store; ++i) {
			int temp = Math.abs(list.get(i) - len);
			answer += Math.min(temp, total - temp);
		}
		System.out.println(answer);
	}
}
