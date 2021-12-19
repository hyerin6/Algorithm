package silver4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B9656 {
	static final String SK = "SK";
	static final String CY = "CY";

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if (N % 2 == 0) {
			System.out.println(SK);
			return;
		}
		System.out.println(CY);
	}
}
