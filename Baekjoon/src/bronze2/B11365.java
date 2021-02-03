package bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11365 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String s = reader.readLine();
			if (s.equals("END"))
				break;
			System.out.println(new StringBuffer(s).reverse().toString());
		}
	}
}
