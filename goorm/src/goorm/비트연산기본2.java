package goorm;

import java.io.*;
import java.util.*;

public class 비트연산기본2 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer t = new StringTokenizer(br.readLine(), " ");

		int a = Integer.parseInt(t.nextToken());
		int b = Integer.parseInt(t.nextToken());

		System.out.println(a >> b);
		System.out.println(a << b);

	}

}
