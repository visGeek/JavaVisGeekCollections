package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.collections.AbstractEnumerator;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class LongCount01 {
	// public static void main(String[] args) {
	// // new LongCount().LongCount01_01();
	// // new LongCount().LongCount01_02();
	// // new LongCount().LongCount02_01();
	// // new LongCount().LongCount02_02();
	// }

	@Test
	public void intCount() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, 3).iterator();
		long expected = 3;

		long actual = source.longCount();
		Assert.assertEquals(expected, actual);
	}

	@Test
	@Ignore
	public void longCount() {
		IEnumerable<String> source =
				() -> new AbstractEnumerator<String>() {
					private long i = 0;

					@Override
					public String current() {
						return null;
					}

					@Override
					public boolean moveNext() {
						this.i++;
						return this.i <= (long) Integer.MAX_VALUE + 1L;
					}
				};

		long expected = (long) Integer.MAX_VALUE + 1L;

		long actual = source.longCount();
		Assert.assertEquals(expected, actual);
	}

	@Test
	@Ignore
	public void overflow() {
		IEnumerable<String> source =
				() -> new AbstractEnumerator<String>() {
					private long i = -100;

					@Override
					public String current() {
						return null;
					}

					@Override
					public boolean moveNext() {
						this.i++;
						return this.i <= Long.MAX_VALUE;
					}
				};

		Action0 action = () -> source.longCount();
		Assert2.assertExceptionThrown(ArithmeticException.class, action);
	}
}
