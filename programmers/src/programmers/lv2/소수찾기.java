package programmers.lv2;

import java.util.Arrays;
import java.util.HashSet;

public class 소수찾기 {

	public static HashSet<Integer> prime = new HashSet<>();
	public static int cnt = 0;
	public static boolean[] NUMBER = new boolean[10000000];

	public static int solution(String numbers) {
		StringBuilder sb = new StringBuilder();
		Arrays.fill(NUMBER, true);
		NUMBER[0] = NUMBER[1] = false;

		String[] numberSplit = numbers.split("");
		boolean[] picked = new boolean[numberSplit.length];
		makeNumber(numberSplit, picked, sb);

		for(int num : prime){
			if(isPrime(num))
				cnt++;
		}

		return cnt;
	}

	public static void makeNumber(String[] numbers, boolean[] picked, StringBuilder sb) {
		int len = picked.length; 
		boolean finished = true;
		for(boolean flag : picked) {
			if(!flag) {
				finished = false;
				break;
			}
		}

		if(finished) return;

		for(int i = 0; i < len; ++i) {
			if(!picked[i]) {
				sb.append(numbers[i]);
				prime.add(Integer.parseInt(sb.toString()));
				picked[i] = true;
				makeNumber(numbers, picked, sb);
				picked[i] = false;
				sb.deleteCharAt(sb.length() - 1);
			}
		}

	}

	public static boolean isPrime(int num){
		// 에라토스테네스의 체를 이용
		for(int i = 2; i <= Math.sqrt(num); i++){
			for(int j = 2; j * i <= num ; j++){
				NUMBER[j * i] = false;
			}
		}
		return NUMBER[num];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(소수찾기.solution("011"));
	}

}
