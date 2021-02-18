package silver5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B14916 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int money = Integer.parseInt(br.readLine());
		int coin = 0;

		while (true) {
			if (money % 5 == 0) {
				bw.write(money / 5 + "\n");
				break;
			}

			if (money < 0) {
				bw.write(-1 + "\n");
				break;
			}

			money -= 2;
			coin++;

			if (money % 5 == 0) {
				coin += money / 5;
				bw.write(coin + "\n");
				break;
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
