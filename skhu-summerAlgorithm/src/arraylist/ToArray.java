package arraylist;

import java.util.ArrayList; 
import java.util.Arrays; 
import java.util.List;

public class ToArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> list = new ArrayList<>();
		list.add("Lion"); 
		list.add("Tiger");
		list.add("Cat");
		list.add("Dog");
		System.out.println(list);

		String[] a = list.toArray(new String[list.size()]); 
		System.out.println(Arrays.toString(a));

	}

}
