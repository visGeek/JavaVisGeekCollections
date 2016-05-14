package com.github.visgeek.utils.collections.test.testcase.collection.map.imap;

import org.junit.Test;

import com.github.visgeek.utils.Func0;
import com.github.visgeek.utils.collections.EnumerableMap;

public class GetValueOrPutSync {
	@Test
	public void serialWithoutLolock() throws InterruptedException {
		EnumerableMap<Integer, String> map = new EnumerableMap<>();
		map.getValueOrPut(0, "0");
		map.getValueOrPut(0, "0");
	}

	@Test
	public void serialWithLolock() throws InterruptedException {
		EnumerableMap<Integer, String> map = new EnumerableMap<>();
		map.getValueOrPut(0, "0", map);
		map.getValueOrPut(0, "0", map);
	}

	@Test
	public void parallelWithLock() throws InterruptedException {
		EnumerableMap<Integer, String> map = new EnumerableMap<>();

		Thread t1 = new Thread(this.threadAction(map, 100L));
		Thread t2 = new Thread(this.threadAction(map, 0L));
		Thread t3 = new Thread(this.threadAction(map, 0L));

		t1.start();

		this.sleep(10);
		t2.start();

		this.sleep(10);
		t3.start();

		t1.interrupt();

		t1.join();
		t2.join();
		t3.join();
	}

	private Runnable threadAction(EnumerableMap<Integer, String> map, long sleepTime) {
		return () -> {
			try {
				Integer key = 0;

				Func0<String> defaultValue =
						() -> {
							this.sleep(sleepTime);
							return key.toString();
						};

				map.getValueOrPut(key, defaultValue, map);
			} catch (Exception e) {
				//
			}
		};
	}

	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
