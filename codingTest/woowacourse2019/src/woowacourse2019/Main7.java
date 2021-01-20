package woowacourse2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main7 {

	static class Solution {

		public static String solution(String cryptogram) {
			String answer = "";		
			boolean check = true;

			String[] arr = cryptogram.split("");
			List<String> result = Arrays.asList(arr);

			while(check) {
				check = false;
				char pre = cryptogram.charAt(0);
				List<String> cur = new ArrayList<>();
				cur.addAll(result);

				for(int i = 0; i < result.size()-1; ++i) {
					if(result.get(i).equals(result.get(i+1))) {
						cur.remove(i+1);
						cur.remove(i);
						result = cur;
						check = true;
						continue;
					}
				}
				result = cur;
				System.out.println(result.toString());
			}

			return answer;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String cryptogram = "browoanoommnaon";
		Solution.solution(cryptogram);
	}

}
