package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10867 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] count = new int[2001];
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i = 0; i < N; ++i) {
			count[Integer.parseInt(st.nextToken())+1000] = 1;
		}

		for(int i = 0; i < count.length; ++i) {
			if(count[i] == 1) {
				System.out.println(i - 1000);
			}
		}
	}
}
