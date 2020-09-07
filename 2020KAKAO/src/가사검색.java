// hint : Trie 알고리즘 
public class 가사검색 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
		String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
		int[] result = Solution.solution(words, queries);

		for(int i = 0; i < result.length; ++i) {
			System.out.print(result[i]);
			if(i < result.length-1) System.out.print(",");
		}
	}

	static class Solution {
		public static int[] solution(String[] words, String[] queries) {
			int[] answer = new int[queries.length];
			int cnt = 0;

			for(int i = 0; i < queries.length; ++i) {
				cnt = 0;
				for(int j = 0; j < words.length; ++j) {
					if(check(words[j], queries[i])) {
						cnt++;
					}
				}
				answer[i] = cnt;
			}

			return answer;
		}

		private static boolean check(String word, String query) {
			if(word.length() != query.length()) return false;

			for(int i = 0; i < word.length(); ++i) {
				if(query.charAt(i) == '?') continue;
				if(query.charAt(i) != word.charAt(i)) return false;
			}

			return true;
		}
	}
}

