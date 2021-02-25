package bronze3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B4690 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 6; i <= 100; ++i) {
			for (int j = 2; j < i; ++j) {
				for (int l = j + 1; l < i; ++l) {
					for (int k = l + 1; k < i; ++k) {
						if (Math.pow(i, 3) == Math.pow(j, 3) + Math.pow(l, 3) + Math.pow(k, 3)) {
							bw.write("Cube = " + i + ", Triple = (" + j + "," + l + "," + k + ")\n");
						}
					}
				}
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
