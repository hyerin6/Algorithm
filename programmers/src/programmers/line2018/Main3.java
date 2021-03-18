package programmers.line2018;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Group {
	int id;
	List<Integer> persons;

	public Group(int id) {
		this.id = id;
		this.persons = new ArrayList<Integer>();
	}

	public int size() {
		return persons.size();
	}

	public int get(int index) {
		return persons.get(index);
	}

	public void add(int id) {
		persons.add(id);
	}
}

public class Main3 {
	static Map<Integer, Group> persons = new HashMap<>();
	static Map<Integer, Group> groups = new HashMap<>();

	static Group createGroup() {
		Group group = new Group(groups.size());
		groups.put(group.id, group);
		return group;
	}

	static void addPersonToGroup(int personId, Group group) {
		group.add(personId);
		persons.put(personId, group);
	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int count = scanner.nextInt();
			for (int i = 0; i < count; ++i) {
				int person1 = scanner.nextInt();
				int person2 = scanner.nextInt();

				Group group1 = persons.get(person1);
				Group group2 = persons.get(person2);

				if (group1 == null && group2 == null) { // 새 그룹 생성
					Group group = createGroup();
					addPersonToGroup(person1, group);
					addPersonToGroup(person2, group);
				} else if (group1 == null) // 한 사람만 찾았으면 한 사람만 그룹에 등록
					addPersonToGroup(person1, group2);
				else if (group2 == null)
					addPersonToGroup(person2, group1);
				else {  // 둘 다 찾았으면
					if (group1 == group2) { // 동일 그룹이면 패스
						continue;
					}
					if (group1.size() < group2.size()) { // 사람 수가 적은 그룹이 group2
						Group temp = group1;
						group1 = group2;
						group2 = temp;
					}
					for (int j = 0; j < group2.size(); ++j) { // group2의 사람을 group1에 등록
						int personId = group2.get(j);
						addPersonToGroup(personId, group1);
					}
					groups.remove(group2.id); // group2 제거
				}
			}
			System.out.println(groups.size());
		}
	}
}

/*
6
1 3
3 4
6 5
11 15
12 17
12 15
 */