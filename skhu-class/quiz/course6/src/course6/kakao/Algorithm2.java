// 2020 KAKAO 코딩테스트 괄호 변환
package course6.kakao;

import java.util.Stack;

public class Algorithm2 {

	// 길이는 2 이상 1,000 이하인 짝수  
	public static String solution(String p) {
		String result = "";
		String u = ""; // 균형잡힌 괄호 문자열 
		String v = "";  
		if(p.isEmpty()) return result;

		String[] arr = p.split("");
		Stack<String> stack = new Stack<>();

		for(int i = 0; i < arr.length; ++i) {
			if(arr[i] == "(") {
				stack.push(arr[i]);
			} else if(arr[i] == ")"){
				if(!stack.isEmpty() && stack.peek() == "(") {
					stack.pop();
				} else {
					int mark = i;
					break;
				}
			} 
		}



		return result;	
	}





	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
