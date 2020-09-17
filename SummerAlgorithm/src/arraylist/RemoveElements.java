package arraylist;

import java.util.ArrayList; 
import java.util.List; 
import java.util.function.Predicate;

public class RemoveElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> list = new ArrayList<>(); 
		list.add("C"); list.add("C++"); 
		list.add("Java"); 
		list.add("Kotlin"); 
		list.add("Python"); 
		list.add("Perl"); 
		list.add("Ruby");
		System.out.println("Initial List: " + list);

		boolean isRemoved = list.remove("Kotlin"); 
		System.out.println("After remove(\"Kotlin\"): " + list);

		List<String> scriptingLanguages = new ArrayList<>(); 
		scriptingLanguages.add("Python");
		scriptingLanguages.add("Ruby"); 
		scriptingLanguages.add("Perl"); 
		list.removeAll(scriptingLanguages); 
		System.out.println("After removeAll(scriptingLanguages): " + list);

		list.removeIf(new Predicate<String>() { 
			@Override 
			public boolean test(String s) { 
				return s.startsWith("C"); 
			} 
		});
		System.out.println("After Removing all elements that start with \"C\": " + list);

		list.clear();
		System.out.println("After clear(): " + list);

	}

}
