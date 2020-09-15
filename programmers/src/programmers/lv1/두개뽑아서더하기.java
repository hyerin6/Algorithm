package programmers.lv1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class 두개뽑아서더하기 {

	static class Solution {
		public List<Integer> solution(int[] numbers) {
			List<Integer> answer = new ArrayList<>();
	        Set<Integer> set = new HashSet<>();

	        for (int i = 0; i < numbers.length - 1; i++) {
	            for (int j = i + 1; j < numbers.length; j++) {
	                set.add(numbers[i] + numbers[j]);
	            }
	        }

	        Iterator<Integer> iter = set.iterator();
	        while(iter.hasNext()) {
	            answer.add(iter.next());
	        }

	        Collections.sort(answer);
	        return answer;
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers1 = {2,1,3,4,1};
		int[] numbers2 = {5,0,2,7};

		System.out.println(new Solution().solution(numbers1).toString());
		System.out.println(new Solution().solution(numbers2).toString());
	}

}
