package producerconsumer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
class ProducerTest {
	BlockingQueue<Integer> dataQueue = null;

	public ProducerTest(BlockingQueue<Integer> dataQueue) {
		this.dataQueue = dataQueue;
	}

	// create Integer Object then add to queue. If after 1000ms that data not
	// used then that data is deleted.
	public void production() throws InterruptedException {
		for (int i = 0; i < 100; i++) {
			dataQueue.offer(new Integer(i),
					ProducerConsumerTest.MAX_TIME_OUT_OFFER,
					TimeUnit.MILLISECONDS);
		}
	}
}

class ConsumerTest implements Callable<Boolean> {
	BlockingQueue<Integer> dataQueue = null;

	public ConsumerTest(BlockingQueue<Integer> dataQueue) {
		this.dataQueue = dataQueue;
	}

	@Override
	public Boolean call() {
		System.out.println((new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"))
				.format(new Date()) + " Consumer Begin");
		boolean isStop = false;
		try {
			while (!isStop) {
				Integer count = dataQueue.poll(
						ProducerConsumerTest.MAX_TIME_OUT_POOL,
						TimeUnit.MILLISECONDS);
				if (count == null) {
					isStop = true;
				} else {
					System.out.println((new SimpleDateFormat(
							"yyyy/MM/dd HH:mm:ss")).format(new Date())
							+ " "
							+ Thread.currentThread().getName()
							+ " count = "
							+ count * 2);
				}
			}
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			System.out.println((new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"))
					.format(new Date()) + " Consumer End");
		}
	}
}

public class ProducerConsumerTest {
	public static final int MAX_QUEUE = 15;
	public static final int MAX_CONSUMER = 5;
	public static final int MAX_TIME_OUT_OFFER = 1000;
	public static final int MAX_TIME_OUT_POOL = 6000;
	private String name;
	private String desc;
	public ProducerConsumerTest(String name,String desc) {
		this.setName(name);
		this.setDesc(desc);
	}

	public static void main(String[] args) {
		// queue for run block queue is json data
		BlockingQueue<Integer> dataQueue = new LinkedBlockingQueue<>(MAX_QUEUE);
		// initialize consumer threads
		ExecutorService executor = Executors.newFixedThreadPool(MAX_CONSUMER);
		// start consumer
		List<Future<Boolean>> futureList = new ArrayList<>();
		try {
			for (int i = 1; i <= MAX_CONSUMER; i++) {
				Future<Boolean> f = executor
						.submit(new ConsumerTest(dataQueue));
				futureList.add(f);
			}
			// start producer
			ProducerTest producer = new ProducerTest(dataQueue);
			producer.production();
			// check consumer result
			boolean hasError = false;
			for (Future<Boolean> consumerRes : futureList) {
				if (consumerRes.get() == Boolean.FALSE) {
					hasError = true;
				}
			}
			if (hasError) {
				System.out.println("There was an error");
			}
		} catch (ExecutionException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println((new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"))
					.format(new Date()) + " Finished!");
			executor.shutdown();
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
