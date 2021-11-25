package silver3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class B9375 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			Map<String, Integer> clothes = new HashMap<>();
			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; ++i) {
				String category = br.readLine().split(" ")[1];
				clothes.put(category, clothes.getOrDefault(category, 0) + 1);
			}

			int result = 1;

			// 안 입는 경우를 고려하여 각 종류별 옷의 개수에 +1 해준 값을 곱해주어야 한다.
			for (int val : clothes.values()) {
				result *= (val + 1);
			}
			// 알몸인 상태를 제외해주어야 하므로 최종값에 -1 
			System.out.println(result - 1);
		}

	}
}