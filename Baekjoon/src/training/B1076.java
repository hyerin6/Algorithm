package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1076 {

	final static String[] colors = {"black", "brown", "red", "orange", "yellow",
		"green", "blue", "violet", "grey", "white"};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String s1 = br.readLine();
		String s2 = br.readLine();
		String s3 = br.readLine();
		long i3 = 1;

		for (int i = 0; i < colors.length; ++i) {
			if (s1.equals(colors[i])) {
				s1 = String.valueOf(i);
			}
			if (s2.equals(colors[i])) {
				s2 = String.valueOf(i);
			}
			if (s3.equals(colors[i])) {
				i3 = (long)Math.pow(10, i);
			}
		}

		int sum = Integer.parseInt(sb.append(s1).append(s2).toString());
		System.out.println(sum * i3);

	}
}
