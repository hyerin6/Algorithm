package goorm;

import java.io.*;
import java.util.*;

public class 회문 { // timeout

	public static boolean test(List<String> list) {
		Stack<String> stack = new Stack<>();
		for(String s : list)
			stack.push(s);
		for(String s : list)
			if(!stack.pop().equals(s))
				return false;
		return true;
	}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());


		for(int i = 0; i < N; ++i) {
			String str = br.readLine();
			String reversed = new StringBuilder(str).reverse().toString();

			if(str.equals(reversed)) {
				System.out.println(0);
				continue;
			}

			else {
				String[] arr = str.split("");
				List<String> list = new ArrayList<>();
				for(String s : arr)
					list.add(s);

				for(int j = 0; j < arr.length; ++j) {
					if(!arr[j].equals(arr[arr.length-j-1])){
						String s1 = list.remove(j);
						if(test(list)) {
							System.out.println(1);
							break;
						}
						list.add(j, s1);
						String s2 = list.remove(arr.length-j-1);
						if(test(list)) {
							System.out.println(1);
							break;
						}
						else {
							System.out.println(2);
							break;
						}
					}
				}
			}
		}
	}
}



