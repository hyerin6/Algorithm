package arraylist;

import java.util.ArrayList; 
import java.util.Collections;
import java.util.Comparator; 
import java.util.List;

public class Sort2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> list = new ArrayList<>(); 
		list.add("13"); 
		list.add("7"); 
		list.add("18"); 
		list.add("5"); 
		list.add("2");
		System.out.println("Before : " + list);

		Collections.sort(list, new Comparator<String>() { 
			@Override 
			public int compare(String s1, String s2) { 
				Integer i1 = Integer.valueOf(s1); 
				Integer i2 = Integer.valueOf(s2); 
				return i1 - i2; 
			} 
		});
		System.out.println("After : " + list);

	}

}
