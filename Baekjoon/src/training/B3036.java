package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3036 {

	static int gcd(int a, int b) {
		return b!=0 ? gcd(b, a%b):a;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

		int n = Integer.parseInt(br.readLine());
		StringTokenizer t = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(t.nextToken());
		for(int i = 1; i < n; ++i) {
			int b = Integer.parseInt(t.nextToken());
			System.out.println(a/gcd(a, b) + "/" + b/gcd(a, b));
		}

	}

}
