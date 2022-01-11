package silver5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B5635 {
	static class Student implements Comparable {
		String name;
		int day;
		int month;
		int year;

		public Student(String name, int day, int month, int year) {
			this.name = name;
			this.day = day;
			this.month = month;
			this.year = year;
		}

		@Override
		public int compareTo(Object o) {
			Student s = (Student)o;
			if (s.year == this.year) {
				if (s.month == this.month) {
					return this.day - s.day;
				}
				return this.month - s.month;
			}
			return this.year - s.year;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<Student> students = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int day = Integer.parseInt(st.nextToken());
			int month = Integer.parseInt(st.nextToken());
			int year = Integer.parseInt(st.nextToken());
			students.add(new Student(name, day, month, year));
		}

		Collections.sort(students);

		bw.write(students.get(N - 1).name + "\n");
		bw.write(students.get(0).name + "\n");
		bw.close();
		br.close();
	}
}
