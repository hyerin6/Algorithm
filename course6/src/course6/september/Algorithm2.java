// 2. 구현
package course6.september;

public class Algorithm2 {

	public static int solution(String str) {
		int result = 0;

		return result;
	}

	// 같은 문자가 반복되면 횟수 표시하여 문자열 압축
	public static String compress(String s, int startIndex, int endIndex) {
		String inputTxt = s;
 		String resultTxt = "";
        int count = 0;
        
        
        String temp = inputTxt.substring(startIndex, endIndex);
        count++;
        
        for ( int i = 1; i < inputTxt.length(); i++ ) {
            
            if ( inputTxt.substring(startIndex) != temp ) {
                resultTxt += temp + "" + count;
                count = 0;
                
                temp = inputTxt.substring(startIndex);
                count++;
                
            } else {
                count++;
            }
            
            if ( i == inputTxt.length()-1 ) {
                resultTxt += temp + "" + count;
            }
        }
        
        return resultTxt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();

	}

}