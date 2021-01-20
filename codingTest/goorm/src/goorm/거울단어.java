package goorm;

import java.io.*;
import java.util.*;

public class 거울단어 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Map<String, String> map = new HashMap<>();
		map.put("b", "d");
		map.put("d", "b");
		map.put("s", "z");
		map.put("p", "q");
		map.put("z", "s");
		map.put("q", "p");
		map.put("i", "i");
		map.put("l", "l");
		map.put("v", "v");
		map.put("u", "u");
		map.put("w", "w");
		map.put("m", "m");
		map.put("o", "o");
		map.put("x", "x");
		map.put("n", "n");

		for(int i = 0; i < N; ++i) {
			String str = br.readLine();
			String[] arr = str.split("");
			int len = arr.length;
			for(int j = 0; j < len; ++j) {
				if(!map.containsKey(arr[j])) {
					System.out.println("Normal");
					break;
				}
				if(!map.get(arr[j]).equals(arr[len-(j+1)])) {
					System.out.println("Normal");
					break;
				} 
				if(j == len-1) {
					System.out.println("Mirror");
				}
			}
		}
	}

}
