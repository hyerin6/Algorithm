package com.swexpertacademy.algorithm.d1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class D2056 {
	/*
	1, 3, 5, 7, 8, 10, 12 : 1 ~ 31
	2 : 1 ~ 28
	9, 11, 4, 6 : 1 ~ 30	
	 */
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; ++i) {
			String str = br.readLine();
			int y = Integer.parseInt(str.substring(0, 4));
			int m = Integer.parseInt(str.substring(4, 6));
			int d = Integer.parseInt(str.substring(6, str.length()));
			boolean result = false;

			if (m <= 0 || m > 12) {
				result = false;
			} else if (m == 2) {
				if (d <= 28 && d > 0) {
					result = true;
				}
			} else if (m == 9 || m == 11 || m == 4 || m == 6) {
				if (d <= 30 && d > 0) {
					result = true;
				}
			} else {
				if (d <= 31 && d > 0) {
					result = true;
				}
			}

			if (result) {
				bw.write("#" + (i + 1) + " " + str.substring(0, 4) +
					"/" + str.substring(4, 6) + "/" + str.substring(6, str.length()) + "\n");
			} else {
				bw.write("#" + (i + 1) + " " + -1 + "\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
