package silver2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 좌표 압축
// 주어진 숫자를 서로 비교하여 자기보다 작은 수를 세는 알고리즘
public class B18870 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int num = Integer.parseInt(br.readLine());
		String[] arr = br.readLine().split(" ");
		int[] an = new int[num];
		int cnt = 0;

		for (int i = 0; i < arr.length; i++) {
			an[i] = Integer.parseInt(arr[i]);
		}

		int[] temp = an.clone();
		Arrays.sort(an);

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < an.length; ++i) {
			if (!map.containsKey(an[i])) {
				map.put(an[i], cnt++);
			}
		}

		System.out.println(map.toString());

		for (int i = 0; i < num; ++i) {
			sb.append(map.get(temp[i])).append(" ");
		}

		System.out.println(sb.toString());
	}
}