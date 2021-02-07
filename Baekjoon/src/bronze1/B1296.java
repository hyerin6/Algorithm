package bronze1;

import java.util.Arrays;
import java.util.Scanner;

public class B1296 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);

		// 1.오만식의 이름
		String line = sc.nextLine();
		int L_oh = 0;
		int O_oh = 0;
		int V_oh = 0;
		int E_oh = 0;
		for (int j = 0; j < line.length(); j++) {
			char check = line.charAt(j);
			if (check == 'L') {
				L_oh++;
			} else if (check == 'O') {
				O_oh++;
			} else if (check == 'V') {
				V_oh++;
			} else if (check == 'E') {
				E_oh++;
			}
		}
		int N = Integer.parseInt(sc.nextLine());
		int min = -1;
		String name = "";

		for (int i = 0; i < N; i++) {
			// 2. 좋아하는 여자 이름
			line = sc.nextLine();
			int L = L_oh;
			int O = O_oh;
			int V = V_oh;
			int E = E_oh;
			for (int j = 0; j < line.length(); j++) {
				char check = line.charAt(j);
				if (check == 'L') {
					L++;
				} else if (check == 'O') {
					O++;
				} else if (check == 'V') {
					V++;
				} else if (check == 'E') {
					E++;
				}
			}

			int ans = ((L + O) * (L + V) * (L + E) * (O + V) * (O + E) * (V + E)) % 100;

			if (ans > min) {
				min = ans;
				name = line;
			} else if (ans == min) {
				String[] sort = new String[2];
				sort[0] = line;
				sort[1] = name;

				// 여러명일 때에는 알파벳으로 가장 앞서는 이름을 출력
				Arrays.sort(sort);
				name = sort[0];
			}
		}
		
		System.out.println(name);
	}

	private static String src = "OHMINSIK\r\n" + "9\r\n" + "YOONA\r\n" + "TIFFANY\r\n" + "YURI\r\n" + "HYOYEON\r\n"
		+ "SOOYOUNG\r\n" + "SEOHYUN\r\n" + "TAEYEON\r\n" + "JESSICA\r\n" + "SUNNY";
}
