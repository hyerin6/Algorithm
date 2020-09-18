package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

public class B2981 {

	static int gcd(int a, int b) {
		return b!=0 ? gcd(b, a%b) : a;
	}

	static TreeSet<Integer> 약수구하기(int value) { 
		TreeSet<Integer> set = new TreeSet<>(); 
		int end = (int)Math.sqrt(value); 
		for (int i = 2; i <= end; ++i) 
			if (value % i == 0) { 
				set.add(i); 
				set.add(value / i); 
			} 
		return set; 
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] a = new int[N];

		for(int i = 0; i < N; ++i) {
			a[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(a); 
		for (int i = 1; i < N; ++i) {
			a[i-1] = a[i] - a[i-1];
		}

		int gcd = a[0];
		for (int i = 0; i < N-2; ++i) {
			int g = gcd(a[i], a[i+1]);
			if(g < gcd) gcd = g;
		}

		TreeSet<Integer> set = 약수구하기(gcd); 
		StringBuilder builder = new StringBuilder(); 
		Iterator<Integer> it = set.iterator();
		while (it.hasNext()) 
			builder.append(it.next()).append(' ');
		builder.append(gcd);
		System.out.println(builder.toString());
	}

}
