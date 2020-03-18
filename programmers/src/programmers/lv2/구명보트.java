package programmers.lv2;

import java.util.*;

public class 구멍보트 {

	public static int solution(int[] people, int limit) {
		Arrays.sort(people);

		int count = 0;
		int min = 0;
		int max = people.length - 1;

		while(min < max) {
			if((people[min]+people[max]) <= limit) {
				count++;
				min++;
				max--;
			}
			else 
				max--;
		}

		return people.length - count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] people1 = {50, 70, 80, 50};
		int[] people2 = {70, 80, 50};

		System.out.println(solution(people1, 100)); // 3
		System.out.println(solution(people2, 100)); // 3

	}

}
