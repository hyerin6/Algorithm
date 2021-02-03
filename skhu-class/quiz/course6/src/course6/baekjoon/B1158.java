package course6.baekjoon;

import java.util.ArrayList;

// 백준 1158 조세퍼스 문제  
public class B1158 {

	public static void solution(int n, int k) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayList<Integer> josepus = new ArrayList<Integer>();

		for(int i=0; i<n; i++) {
			arr.add(i+1);
		}

		// 미완성 
		int tmp = 0;
		while(!arr.isEmpty()) {
			tmp = (tmp+k-1)%arr.size();
			josepus.add(arr.remove(tmp));
		}
		System.out.print("<");
		for(int i=0; i<n; i++) {
			System.out.print(josepus.get(i));

			if(i!=n-1) {
				System.out.print(", ");
			}
		}
		System.out.print(">");
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		solution(10, 3);

	}

}
