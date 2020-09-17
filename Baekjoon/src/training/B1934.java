package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1934 {

	static int gcd(int a, int b) {
		return b!=0 ? gcd(b, a%b) : a;
	}

	static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

		int n = Integer.parseInt(br.readLine());

		for(int i = 0; i < n; ++i) {
			StringTokenizer t = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(t.nextToken());
			int b = Integer.parseInt(t.nextToken());
			System.out.println(lcm(a, b));
		}

	}

}
