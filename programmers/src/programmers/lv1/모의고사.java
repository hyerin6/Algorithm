package programmers.lv1;

import java.util.*;

public class 모의고사 {

	static int[] a1 = {1, 2, 3, 4, 5}; // 5
	static int[] a2 = {2, 1, 2, 3, 2, 4, 2, 5}; // 8
	static int[] a3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 10

	public static int[] solution(int[] answers) {
		int[] count = new int[3];

		for(int i = 0; i < answers.length; ++i) {
			if(answers[i] == a1[i%5])
				count[0]++;
			if(answers[i] == a2[i%8])
				count[1]++;
			if(answers[i] == a3[i%10])
				count[2]++;
		}

		int max = count[0];
		for(int i = 0; i < count.length; ++i)
			if(max < count[i])
				max = count[i];

		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < count.length; ++i)
			if(max == count[i])
				list.add(i+1);

		int[] answer = new int[list.size()];
		for(int i = 0; i < list.size(); ++i)
			answer[i] = list.get(i);

		return answer;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] answers1 = {1,2,3,4,5};
		System.out.println(Arrays.toString(solution(answers1)));

		int[] answers2 = {1,3,2,4,2};
		System.out.println(Arrays.toString(solution(answers2)));

	}

}
