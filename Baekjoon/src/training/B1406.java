package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;
import java.util.LinkedList;

class Editor {

	List<Character> list;
	ListIterator<Character> it;

	int index = 0;

	Editor(char[] arr) {
		list = new LinkedList<>();
		it = list.listIterator(list.size());
		pushInitStr(arr);
	}

	public void L() {
		if (it.hasPrevious())
			it.previous();
	}

	public void D() {
		if (it.hasNext()) 
			it.next();
	}

	public void B() {
		if (it.hasPrevious()) {
			it.previous();
			it.remove();
		}
	}

	public void P(char c) {
		it.add(c);
	}

	public void printStr() {
		StringBuilder sb = new StringBuilder();
		for (char c : list) 
			sb.append(c);

		System.out.print(sb);
	}

	private void pushInitStr(char[] arr) {
		for (int i = 0; i < arr.length; i++) 
			P(arr[i]);
	}

}

public class B1406 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		int N;
		String cmd;

		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Editor editor = new Editor(br.readLine().toCharArray());
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			cmd = st.nextToken();

			switch (cmd) {
			case "L":
				editor.L();
				break;
				
			case "D":
				editor.D();
				break;
				
			case "B":
				editor.B();
				break;
				
			case "P":
				char c = st.nextToken().charAt(0);
				editor.P(c);
				break;

			default:
				break;
			}
		}

		editor.printStr();
	}

}
