package synchronizedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadSafe2a {

	public static void main(String[] args) throws InterruptedException {
		List<Integer> list = new ArrayList<>();
		List<Integer> list2 = Collections.synchronizedList(list);

		for (int i = 0; i < 10; ++i)
			list.add(i);

		// Create a thread pool of size 10
		ExecutorService executorService = Executors.newFixedThreadPool(10);

		// Create a Runnable task that increments each element of the ArrayList by one
		Runnable task = () -> {
			list2.add(list2.size());
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

