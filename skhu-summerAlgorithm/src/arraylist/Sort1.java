package arraylist;

import java.util.ArrayList; 
import java.util.Collections; 
import java.util.List;

public class Sort1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> list = new ArrayList<>(); 
		list.add("13"); 
		list.add("7"); 
		list.add("18"); 
		list.add("5"); 
		list.add("2");
		System.out.println("Before : " + list);

		Collections.sort(list);
		System.out.println("After : " + list);

	}

}
