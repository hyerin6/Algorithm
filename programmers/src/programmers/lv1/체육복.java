package programmers.lv1;

import java.util.*;

public class 체육복 {

	public static int solution(int n, int[] lost, int[] reserve) {
		List<Integer> list = new ArrayList<>();
		List<Integer> re = new ArrayList<>();

		for(int i : lost)
			list.add(i);

		for(int i : reserve)
			re.add(i);

		for(int i = 0; i < reserve.length; ++i) {
			if(list.contains(reserve[i])) {
				list.remove(list.indexOf(reserve[i]));
				reserve[i] = -1;
			}
			if(!list.contains(reserve[i]) && list.contains(reserve[i]-1) && !re.contains(reserve[i]-1)) {
				list.remove(list.indexOf(reserve[i]-1));
				reserve[i] = -1;
			}
			if(!list.contains(reserve[i]) && list.contains(reserve[i]+1) && !re.contains(reserve[i]+1)) {
				list.remove(list.indexOf(reserve[i]+1));
				reserve[i] = -1;
			}
		}

		return n-list.size();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n1 = 4;
		int[] lost1 = {2, 4};
		int[] reserve1 = {3};

		int n2 = 3;
		int[] lost2 = {3};
		int[] reserve2 = {1};

		int n3 = 30;
		int[] lost3 = {2, 30};
		int[] reserve3 = {2};

		int n4 = 5;
		int[] lost4 = {2, 4};
		int[] reserve4 = {1, 3, 5};

		int n5 = 10;
		int[] lost5 = {3, 9, 10}; 
		int[] reserve5 = {3, 8, 9};

		System.out.println(solution(n1, lost1, reserve1)); // 3
		System.out.println(solution(n2, lost2, reserve2)); // 2
		System.out.println(solution(n3, lost3, reserve3)); // 29
		System.out.println(solution(n4, lost4, reserve4)); // 5
		System.out.println(solution(n5, lost5, reserve5)); // 9

	}

}
