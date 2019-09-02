package ebay2019;

public class Exam1a {

	/*
	 *  가장 쉬운 방법으로 최대한 빨리 구현한다. 
	 *  배열의 최대 크기가 100,000이라는 것은 성능이 중요하다는 의미이다. 
	 *  아래의 구현은 O(n^2) 이기 때문에 O(n) 방법을 찾아보다. 
	 */
	public static int solution1(int[] prices) {
		int max = 0;
		for(int i = 0; i < prices.length; ++i) {
			for(int j = 0; j < prices.length; ++j) {
				int value = prices[j] - prices[i];
				if(value > max) max = value;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution1(new int[] { 3, 2, 4, 8, 7 })); 
		System.out.println(solution1(new int[] { 3, 4, 1, 5, 4 }));
	}

}
