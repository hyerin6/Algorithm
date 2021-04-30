package programmers.line2018;

import java.util.ArrayList;
import java.util.Scanner;

public class Main5_v2 {

	static final Schedule EMPTY_SCHEDULE = new Schedule();

	static Schedule findMaxSchedule(Schedule.Job[] a, Schedule 일정, int index) {
		if (일정.isImpossible()) {
			return EMPTY_SCHEDULE;
		}
		if (index >= a.length) {
			return 일정;
		}
		Schedule 일정1 = findMaxSchedule(a, 일정.add(a[index]), index + 1);
		Schedule 일정2 = findMaxSchedule(a, 일정, index + 1);
		return 일정1.amount() > 일정2.amount() ? 일정1 : 일정2;
	}

	static Schedule.Job[] getJobData() {
		try (Scanner scanner = new Scanner(System.in)) {
			int count = scanner.nextInt();
			Schedule.Job[] a = new Schedule.Job[count];
			for (int i = 0; i < count; ++i) {
				int start = scanner.nextInt();
				int duration = scanner.nextInt();
				int pay = scanner.nextInt();
				a[i] = new Schedule.Job(start, duration, pay);
			}
			return a;
		}
	}

	public static void main(String[] args) {
		System.out.println(findMaxSchedule(getJobData(), EMPTY_SCHEDULE, 0));
	}

	static class Schedule {
		public static class Job {
			int start, duration, pay;

			public Job(int start, int duration, int pay) {
				this.start = start;
				this.duration = duration;
				this.pay = pay;
			}
		}

		ArrayList<Job> list = new ArrayList<>();

		public boolean isImpossible() {
			if (list.size() <= 1)
				return false;
			for (int i = 0; i < list.size() - 1; ++i) {
				Job job1 = list.get(i);
				Job job2 = list.get(i + 1);
				if (job1.start + job1.duration > job2.start)
					return true;
			}
			return false;
		}

		public int amount() {
			int sum = 0;
			for (Job job : list) {
				sum += job.pay;
			}
			return sum;
		}

		public Schedule add(Job job) {
			Schedule schedule = this.clone();
			schedule.list.add(job);
			return schedule;
		}

		@Override
		public Schedule clone() {
			Schedule schedule = new Schedule();
			schedule.list.addAll(this.list);
			return schedule;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append(String.format("%d\n", amount()));
			for (Job job : list)
				builder.append(String.format("%d %d\n", job.start, job.duration));
			return builder.toString();
		}
	}

}
