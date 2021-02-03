package bronze3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B5086 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer t = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(t.nextToken());
			int b = Integer.parseInt(t.nextToken());
			if (a == 0 && b == 0)
				break;
			String s = "neither";
			if (b % a == 0)
				s = "factor";
			else if (a % b == 0)
				s = "multiple";
			System.out.println(s);
		}

	}

}
