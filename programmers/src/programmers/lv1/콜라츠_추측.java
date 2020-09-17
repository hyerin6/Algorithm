package programmers.lv1;

public class 콜라츠_추측 {

	static class Solution {
		public int solution(int num) {
			long n = (long)num;
			for(int i = 0; i < 500; ++i){      
				if(n == 1) return i;
				n = (n%2==0) ? n/2 : n*3+1;            
			}

			return -1;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().solution(6));
		System.out.println(new Solution().solution(16));
		System.out.println(new Solution().solution(626331));
	}

}
