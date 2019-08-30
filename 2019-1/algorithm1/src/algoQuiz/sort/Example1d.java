package algoQuiz.sort;
import java.util.Arrays;
/*
Java 표준 라이브러리의 클래스 중에서,
객체들의 정렬 순서 기준이 한 개 있는 클래스들은
(예: String, Date, Integer, Double, Long, Float, Character),
Comparable 인터페이스를 implements하여 compareTo 메소드를 구현하였다.

Comparable 인터페이스를 implements한 클래스의 객체들은,
Comparable 인터페이스의 자식 클래스 객체인 것 처럼 사용할 수 있다.

Comparable temp 변수와 Comparable[] a 배열에,
Comparable 인터페이스의 자식 클래스 객체를 넣을 수 있다.
 */

public class Example1d {

	static void swap(Comparable[] a, int i, int j) {
		Comparable temp = a[i]; 
		a[i] = a[j]; 
		a[j] = temp;
	}

	static void bubbleSort(Comparable[] a) {
		for (int i = a.length - 1; i >= 1; --i) { 
			boolean 완료 = true;
			for (int j = 0; j < i; ++j) {
				if (a[j].compareTo(a[j + 1]) > 0) {
					swap(a, j, j + 1); 
					완료 = false;
				}
			}
			if (완료) break;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = { "zero", "one", "two", "three", "four", "five", "six", "seven" };

		bubbleSort(a); 
		System.out.println(Arrays.toString(a));

	}

}
