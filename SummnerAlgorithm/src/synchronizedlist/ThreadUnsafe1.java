package synchronizedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadUnsafe1 {

	public static void main(String[] args) throws InterruptedException {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; ++i)
			list.add(0);

		// Create a thread pool of size 10
		ExecutorService executorService = Executors.newFixedThreadPool(10);

		// Create a Runnable task that increments each element of the ArrayList by one
		Runnable task = () -> {
			// Increment all the values in the ArrayList by one
			for(int i = 0; i < list.size(); i++) {
				Integer value = list.get(i);
				list.set(i, value + 1);
			}
		};

		// Submit the task to the executor service 100 times.
		// All the tasks will modify the ArrayList concurrently
		for(int i = 0; i < 100; i++) {
			executorService.submit(task);
		}

		executorService.shutdown();
		executorService.awaitTermination(60, TimeUnit.SECONDS);

		System.out.println(list);
	}
}
