package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B1235 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String[] students = new String[N];
		int len = 0;

		for (int i = 0; i < N; ++i) {
			students[i] = br.readLine();
			if (i == 0) {
				len = students[i].length();
			}
		}

		for (int j = len; j >= 0; --j) {
			List<String> list = new ArrayList<>();
			boolean flag = false;
			for (int i = 0; i < N; ++i) {
				String student = students[i].substring(j - 1);

				if (list.contains(student)) {
					flag = true;
					break;
				} else {
					list.add(student);
				}
			}
			if (!flag) {
				System.out.println(len - j + 1);
				return;
			}
		}
	}
}
