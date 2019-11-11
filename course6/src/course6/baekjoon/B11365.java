package course6.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 백준 11365번 !밀급 급일
public class B11365 {

	public static void solution() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) { 
			String s = null;
			try {
				s = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

			if (s.equals("END")) 
				break; 

			System.out.println(new StringBuffer(s).reverse().toString()); 
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution();

	}

}
