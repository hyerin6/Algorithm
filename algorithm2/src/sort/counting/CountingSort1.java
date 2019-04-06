package sort.counting;
import java.util.Map;
import java.util.TreeMap;

public class CountingSort1 {
	/*
	 * TreeMap의 get과 put은 o(log n)이다. 
	 * 그런데 이 경우는 상수로 취급해야 한다. 
	 * n과 관계 없기 때문이다. 
	 * (Map 데이터의 수: 배열 a에 들어있는 char의 종류의 수)
	 */
	public static void countingSort(char[] a) {
		Map<Character, Integer> countMap = new TreeMap<>();
		for(char c : a) { // 각 문자의 수를 센다. 
			Integer i = countMap.get(c);
			if(i == null) i = 0;
			countMap.put(c, i+1);
		}

		int index = 0;
		for(char c : countMap.keySet()) // 각 문자의 수 만큼 배열에 채운다. O(1)
			for(int i = 0; i < countMap.get(c); ++i) 
				a[index++] = c;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[] a = "hello world. good morning. how are you.".toCharArray();
		countingSort(a);
		System.out.printf("[%s]\n", new String(a));
	}

}
