package silver5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B1064 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int ax = Integer.parseInt(st.nextToken());
		int ay = Integer.parseInt(st.nextToken());
		int bx = Integer.parseInt(st.nextToken());
		int by = Integer.parseInt(st.nextToken());
		int cx = Integer.parseInt(st.nextToken());
		int cy = Integer.parseInt(st.nextToken());

		if ((by - ay) * (cx - bx) == (bx - ax) * (cy - by)) {
			System.out.println("-1");
		} else {
			double one = Math.sqrt(Math.pow(by - ay, 2) + Math.pow(bx - ax, 2));
			double two = Math.sqrt(Math.pow(cy - ay, 2) + Math.pow(cx - ax, 2));
			double three = Math.sqrt(Math.pow(cy - by, 2) + Math.pow(cx - bx, 2));

			double len1 = one + two;
			double len2 = two + three;
			double len3 = one + three;

			double min = Math.min(Math.min(len1, len3), len2);
			double max = Math.max(Math.max(len1, len3), len2);

			System.out.println((max - min) * 2);
		}

	}
}
