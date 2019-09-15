// 2. 구현
package course6.september;

import java.util.HashMap;
import java.util.Map;

public class algorithm2 {

	public static int solution(String str) {
		String[] arr = str.split("");
		Map<String, Integer> map = new HashMap<>();
		String maxValue = ""; 
		int maxCount = 0, maxValueIndex = 0;

		for(int i = 0; i < arr.length - 1; ++i) {
			
			if()
			
			// map.put(arr[i], count == null ? 1 : count + 1);
			
			if(map.get(arr[i]) > maxCount) {
				maxCount = map.get(arr[i]);
				maxValue = arr[i];
				maxValueIndex = i;
			}
		}
		

		
		
		
		return maxValueIndex;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		solution("aabbaccc");

	}

}
