package course;
import java.util.Scanner;

public class B1152 {

	// 시스템 분석 및 설계의 상태 다이어그램(UML)으로 로직 설계를 해보자.
	static int count(String s) {
		int count = 0;
		boolean 알파벳읽는중 = false;

		for(int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			if (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')) {
				if(알파벳읽는중 == false) {
					알파벳읽는중 = true;
					++count;
				} 
			} else 알파벳읽는중 = false;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1152 단어의 개수");
		try (Scanner scanner = new Scanner(System.in)) {
			String s = scanner.nextLine(); 
			System.out.println(count(s));
		}

	}

}
