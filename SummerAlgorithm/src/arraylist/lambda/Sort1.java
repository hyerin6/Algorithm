package arraylist.lambda;

import java.util.ArrayList; 
import java.util.Collections;
import java.util.Comparator; 
import java.util.Random;

public class Sort1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random random = new Random(); 
		ArrayList<Integer> list = new ArrayList<>(); 
		for (int i = 0; i < 10; ++i) 
			list.add(random.nextInt(20));

		// 오름차순 정렬 
		Collections.sort(list); 
		System.out.println(list); 

		// Comparator를 사용하여 정렬 
		Collections.sort(list, new Comparator<Integer>() {
			@Override 
			public int compare(Integer i1, Integer i2) { 
				return i2 - i1; // 내림차순 정렬
			} 
		}); 
		System.out.println(list); 

		// lambda expression 
		Collections.sort(list, (Integer i1, Integer i2) -> { return i2 - i1; } ); 
		System.out.println(list); 

		// lambda expression : 메소드 본문 생략 
		Collections.sort(list, (Integer i1, Integer i2) -> i2 - i1); 
		System.out.println(list); 

		// lambda expression : 파라미터 타입 생략
		Collections.sort(list, (i1, i2) -> i2 - i1); 
		System.out.println(list);

	}

}
