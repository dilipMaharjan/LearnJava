package com.dilipmaharjan.learnjava.durgasoft.Multithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultithreadedApp {
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		MyThread myThread1 = new MyThread();
		myThread.setName("myThread");// jvm sets jvm generated name of not set explicitly
		myThread.setPriority(10); // since child thread has higher priority, child job executes before parent
									// thread
		myThread.start();
		myThread1.start();

		myThread.run();// run method will execute as normal method
		for (int i = 0; i < 10; i++)
			System.out.println("Main Thread");

		System.out.println("-----------Callable-------------");
		CallableApp[] callableApp = {
				new CallableApp(10),
				new CallableApp(11),
				new CallableApp(12),
				new CallableApp(13),
				new CallableApp(14),
				new CallableApp(15),
				
				new CallableApp(10),
				new CallableApp(11),
				new CallableApp(12),
				new CallableApp(13),
				new CallableApp(14),
				new CallableApp(15)

		};
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		for (CallableApp job : callableApp) {
			Future<Integer> f = executorService.submit(job);
			try {
				System.out.println(f.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		executorService.shutdown();

	}

}
