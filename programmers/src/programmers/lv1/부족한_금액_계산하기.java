package programmers.lv1;

public class 부족한_금액_계산하기 {

	public static long solution(int price, int money, int count) {
		long amount = 0;

		for (int i = 1; i <= count; ++i) {
			amount += price * i;
		}

		return amount - money < 0 ? 0 : amount - money;
	}

	public static void main(String[] args) {
		long result = solution(3, 20, 4);
		System.out.println(result);
	}

}
