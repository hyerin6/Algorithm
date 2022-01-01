package silver4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3048 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N1 = Integer.parseInt(st.nextToken());
		int N2 = Integer.parseInt(st.nextToken());
		String group1 = br.readLine();

		// 첫번째 그룹 뒤집어서 저장
		char a1[] = new char[N1];
		for (int i = group1.length() - 1; i >= 0; --i) {
			a1[group1.length() - 1 - i] = group1.charAt(i);
		}
		// 두 번째 그룹 저장
		char a2[] = br.readLine().toCharArray();
		char ants[] = new char[N1 + N2]; // 모든 개미 순서 
		int dir[] = new int[N1 + N2]; // 방향

		// 방향 저장
		for (int i = 0; i < N1; ++i) {
			ants[i] = a1[i];
			dir[i] = 1; //왼쪽에서 오른쪽
		}
		for (int i = N1; i < N1 + N2; ++i) {
			ants[i] = a2[i - N1];
			dir[i] = 2; //오른쪽에서 왼쪽
		}

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			for (int i = 0; i < N1 + N2 - 1; ++i) {
				// 자신의 앞에 반대 방향으로 움직이던 개미가 있는 경우
				// 점프한다. = swap한다.
				if (dir[i] == 1 && dir[i + 1] == 2) {
					char temp = ants[i];
					ants[i] = ants[i + 1];
					ants[i + 1] = temp;
					int tdir = dir[i];
					dir[i] = dir[i + 1];
					dir[i + 1] = tdir;
					i++;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N1 + N2; ++i) {
			sb.append(ants[i]);
		}
		System.out.println(sb.toString());
	}
}
