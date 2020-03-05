package training;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * push X: 정수 X를 스택에 넣는 연산이다.
 * pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * size: 스택에 들어있는 정수의 개수를 출력한다.
 * empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
 * top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */
class MyStack<T>{

	Object[] o;
	int count;

	public MyStack() {
		o = new Object[10];
		count = 0;
	}

	public void push(T value) {
		if (isFull()) 
			expand(); 
		o[count] = value; 
		++count;
	}

	public boolean isFull() {
		return o.length == count;
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public int size() {
		return count; 
	}

	public void expand() {
		o = Arrays.copyOf(o, (int)(o.length * 2)); 
	}

	@SuppressWarnings("unchecked")
	public T pop() throws Exception { 
		if (isEmpty()) throw new Exception("stack empty"); 
		--count; 
		return (T)o[count];
	}

	@SuppressWarnings("unchecked")
	public T top() throws Exception {
		if (isEmpty()) throw new Exception("stack empty");
		return (T)o[count - 1];
	}

}

public class B10828 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		MyStack<Integer> stack = new MyStack<>();

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(reader.readLine());

		for(int i = 0; i < N; ++i) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine()); 
			String cmd = tokenizer.nextToken();

			switch (cmd.toLowerCase()) {
			case "push": stack.push(Integer.parseInt(tokenizer.nextToken())); break;
			case "pop": System.out.println(stack.isEmpty() ? -1 : stack.pop()); break; 
			case "top": System.out.println(stack.isEmpty() ? -1 : stack.top()); break; 
			case "size": System.out.println(stack.size()); break; 
			case "empty": System.out.println(stack.isEmpty() ? 1 : 0); break;
			}
		}

	}

}
