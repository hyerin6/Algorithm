/* Hint
 * | -> 둘 중 하나라도 1이면 1, 아니면 0 (OR)
 * & -> 둘 중 모두 1이면 1, 아니면 0 (AND)
 * ^ -> 두 비트가 다를 때 1 출력 (XOR)
 * ~ -> 비트 전환 연산자 / 1이면 0, 0이면 1로 전환 
 */

public class 비밀지도 {

	static class Solution {

		public String[] solution(int n, int[] arr1, int[] arr2) {
			String[] answer = new String[n];

			for(int i = 0; i < n; i++){
				answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
				// 비트연산 : 7 | 2 이면 00111 | 00001 일 때 하나라도 1이면 1, 아니면 0
			}
			for(int i = 0; i < n; i++){
				answer[i] = String.format("%" + n + "s", answer[i]);
				answer[i] = answer[i].replace("1", "#"); 
				answer[i] = answer[i].replace("0", " "); 
			}  

			return answer;
		} 

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int [] arr1 = {9, 20, 28, 18, 11};
		int [] arr2 = {30, 1, 21, 17, 28};
		String[] result = s.solution(5, arr1, arr2);
		for(String ss : result) System.out.println(ss);

		System.out.println();
		int [] arr3 = {46, 33, 33 ,22, 31, 50};
		int [] arr4 = {27 ,56, 19, 14, 14, 10};
		String[] result2 = s.solution(6, arr3, arr4);
		for(String ss : result2) System.out.println(ss);
	}

}
