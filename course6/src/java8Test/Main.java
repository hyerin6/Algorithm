package java8Test;

public class Main implements Calculator{ 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator c = new Main();
		System.out.println("1 + 2 = " + c.plus(1, 2));
		System.out.println("1 * 2 = " + c.multiple(1, 2));
	}

}
