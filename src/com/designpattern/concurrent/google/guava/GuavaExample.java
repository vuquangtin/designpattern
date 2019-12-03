package com.designpattern.concurrent.google.guava;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class GuavaExample {
	public static void main(String[] args) {
		// Executor executor = MoreExecutors.directExecutor();
		//
		// AtomicBoolean executed = new AtomicBoolean();
		//
		// executor.execute(() -> {
		// try {
		// Thread.sleep(500);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// executed.set(true);
		// });

		// assertTrue(executed.get());
	}

	public static void more() {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors
				.newFixedThreadPool(5);
		ExecutorService executorService = MoreExecutors
				.getExitingExecutorService(executor, 100, TimeUnit.MILLISECONDS);

		executorService.submit(() -> {
			while (true) {
			}
		});
	}

	public void mo() {
		ExecutorService executorService = Executors.newCachedThreadPool();
		ListeningExecutorService listeningExecutorService = MoreExecutors
				.listeningDecorator(executorService);

		ListenableFuture<String> future1 = listeningExecutorService
				.submit(() -> "Hello");
		ListenableFuture<String> future2 = listeningExecutorService
				.submit(() -> "World");

		try {
			String greeting = Futures.allAsList(future1, future2).get().stream()
					.collect(Collectors.joining(" "));
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//assertEquals("Hello World", greeting);

	}
}
