package synchronizedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadSafe2b {

	public static void main(String[] args) throws InterruptedException {
		List<Integer> list = new ArrayList<>();

		// Create a thread pool of size 10
		ExecutorService executorService = Executors.newFixedThreadPool(10);

		// Create a Runnable task that adds element to the end of the ArrayList
		Runnable task = () -> {
			synchronized(list) {
				list.add(list.size());
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
