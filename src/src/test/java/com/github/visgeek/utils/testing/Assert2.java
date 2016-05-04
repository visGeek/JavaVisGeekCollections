package com.github.visgeek.utils.testing;

import java.util.Iterator;
import java.util.Objects;

import org.junit.Assert;

public class Assert2 {
	private Assert2() {
	}

	@SafeVarargs
	public static <T> void assertSequanceEquals(Iterable<T> actual, T... expected) {
		Assert2.assertSequanceEquals(null, actual, expected);
	}

	@SafeVarargs
	public static <T> void assertSequanceEquals(String message, Iterable<T> actual, T... expected) {
		Iterator<T> itr = actual.iterator();

		int count = 0;
		while (itr.hasNext()) {
			count++;

			if (expected.length < count) {
				Assert.fail(message);
			}

			T item = itr.next();
			if (!Objects.equals(item, expected[count - 1])) {
				Assert.fail(message);
			}
		}

		if (count < expected.length) {
			Assert.fail(message);
		}
	}
}
