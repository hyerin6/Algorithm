
public class 문자열압축 {

	public static int solution(String s) {
		int answer = Integer.MAX_VALUE;

		for(int len = 1 ; len < s.length()/2+1; ++len){ // 문자 쪼개는 단위          
			String compressed = "";
			String target = "";
			String current = "";
			int cnt = 1;

			for(int i = 0; i < len; ++i) {
				target += s.charAt(i);
			}

			for(int i = len; i < s.length(); i+=len){  
				current = "";
				for(int j = i; j < i+len; ++j){ // 0부터 x, 비교할 단어 생성
					if(j >= s.length()) break;
					current += s.charAt(j);
				}   

				if(target.equals(current)){
					cnt++;
				} else {
					if(cnt > 1){
						compressed += cnt + target;
					} else {
						compressed += target;
					}
					cnt = 1;
					target = current;
				}
			}

			if(cnt > 1){
				compressed += cnt + target;
			} else {
				compressed += target;
			}

			int length = compressed.length();
			answer = answer > length ? length : answer;
		}

		if(answer == Integer.MAX_VALUE) answer = 1;
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("aabbaccc: " + solution("aabbaccc"));
		System.out.println("ababcdcdababcdcd: " + solution("ababcdcdababcdcd"));
		System.out.println("abcabcdede: " + solution("abcabcdede"));
		System.out.println("abcabcabcabcdededededede: " + solution("abcabcabcabcdededededede"));
		System.out.println("xababcdcdababcdcd: " + solution("xababcdcdababcdcd"));
	}

}
