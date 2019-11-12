// 2020 KAKAO 코딩테스트 문자열 압축 
package course6.kakao;
/*
 * 인덱스 -> range
 * 
 * 0 = 1 -> (0, 1) = (1, 2)
 * 1 = 2 -> (1, 2) = (2, 3) 
 * 2 = 3 -> (2, 3) = (3, 4)
 * 3 = 4 
 * 
 * 
 * 01 = 23 -> (0, 2) = (2, 4)
 * 23 = 45 -> (2, 4) = (4, 6)
 * 45 = 67 -> (4, 6) = (6, 8)
 * 
 * 
 * 012 = 345 -> (0, 3) = (3, 6)
 * 345 = 678 -> (3, 6) = (6, 9)
 */
public class Algorithm1 {

	// s 길이는 1이상 1000이하
	public static int solution(String s) {
		int count = 0;
		int result = s.length();

		for(int i = 1; i <= s.length(); ++i) { // i 개씩 자른다. 

			int len = s.length();
			int k = 0;
			for( ; k + i <= s.length();) { 
				String temp = s.substring(k, k+i);
				k += i;

				count = 0;
				for( ; k+i <= s.length();) {
					if(temp.equals(s.substring(k, k+i))) {
						++count;
						k += i;
					} else {
						break;
					}	
				}

				if(count > 0) {
					len -= i * count;

					if(count < 10) {
						len += 1;
					} else if(count < 99) {
						len += 2;
					} else if(count < 999) {
						len += 3;
					} else {
						len += 4;
					}

				}

			}
			result = Math.min(result, len);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcabcabcabcdededededede";
		System.out.println(solution(s));
	}

}