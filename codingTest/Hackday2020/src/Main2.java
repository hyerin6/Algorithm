import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Arrays;

public class Main2 {

	public static int solution(String[] id_list, int k) {
		int answer = 0;

		Map<String, Integer> map = new HashMap<>();

		for(int i = 0; i < id_list.length; ++i) {
			String[] s = id_list[i].split(" ");
			s = new HashSet<String>(Arrays.asList(s)).toArray(new String[0]);
			for(int j = 0; j < s.length; ++j) {
				if(map.containsKey(s[j])) {
					int count = map.get(s[j]);
					if(map.get(s[j]) < k) 
						map.replace(s[j], count, count+1);
				}
				else 
					map.put(s[j], 1);
			}
		}
		
		for(Map.Entry<String, Integer> entry : map.entrySet())
			answer += entry.getValue();
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] str = {"A B C D", "A D", "A B D", "B D"};
		String[] str2 = {"JAY", "JAY ELLE JAY MAY", "MAY ELLE MAY", "ELLE MAY", "ELLE ELLE ELLE", "MAY"};
		System.out.println(solution(str, 2));
		System.out.println(solution(str2, 3));
	}

}
