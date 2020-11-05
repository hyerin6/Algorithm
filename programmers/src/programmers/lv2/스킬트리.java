package programmers.lv2;

import java.util.*;

public class 스킬트리 {

	static class Solution {
		public static int solution1(String skill, String[] skill_trees) {
			int answer = skill_trees.length;
			int beforeIdx = 0;
			int currentIdx = 0;

			for (int i = 0; i < skill_trees.length; ++i) {
				// 첫 번째 순서의 스킬을 beforeIdx 에 담아둔다.
				beforeIdx = skill_trees[i].indexOf(skill.charAt(0));

				// 두 번째 스킬부터 비교하기 위한 반복문을 수행 
				for (int j = 1; j < skill.length(); ++j) {

					// 비교하고자 하는 스킬의 인덱스를 구하여 currentIdx 에 담아둔다. 
					currentIdx = skill_trees[i].indexOf(skill.charAt(j));

					// 이전 스킬이 스킬트리에 없는데 현재 스킬이 스킬트리에 있다면 불가능한 스킬트리이다. 
					if((beforeIdx > currentIdx && currentIdx != -1) || (beforeIdx == -1 && currentIdx != -1)) {
						answer--;
						break;
					} 

					// 불가능한 경우가 아니라면 다음 스킬의 조회를 위해 현재 인덱스의 값을 이전 인덱스에 담아둔다.
					beforeIdx = currentIdx;
				}
			}

			return answer;
		}

		public static int solution2(String skill, String[] skill_trees) {
			int answer = 0;
			ArrayList<String> skillTrees = new ArrayList<String>(Arrays.asList(skill_trees));
			Iterator<String> it = skillTrees.iterator();

			while (it.hasNext()) {
				if (skill.indexOf(it.next().replaceAll("[^" + skill + "]", "")) != 0) {
					it.remove();
				}
			}
			answer = skillTrees.size();
			return answer;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String skill = "CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA", "CED"};

		System.out.println(Solution.solution1(skill, skill_trees));
		System.out.println(Solution.solution2(skill, skill_trees));
	}

}
