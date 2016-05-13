package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import java.util.function.Predicate;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.collections.AbstractEnumerator;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class LongCount02 {
	// public static void main(String[] args) {
	// //new LongCount().LongCount01_01();
	// // new LongCount().LongCount01_02();
	// // new LongCount().LongCount02_01();
	// // new LongCount().LongCount02_02();
	// }

	@Test
	public void predicteIsNull() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, 3).iterator();
		Predicate<Integer> predicate = null;

		Action0 action = () -> source.longCount(predicate);
		Assert2.assertNullPointerExceptionThrown("predicate", action);
	}

	@Test
	public void intCount() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, 3, 4, 5, 6).iterator();
		Predicate<Integer> predicate = n -> 4 <= n;
		long expected = 3;

		long actual = source.longCount(predicate);
		Assert.assertEquals(expected, actual);
	}

	@Test
	@Ignore
	public void longCount() {
		IEnumerable<Long> source =
				() -> new AbstractEnumerator<Long>() {
					private long i = 0;

					@Override
					public Long current() {
						return this.i;
					}

					@Override
					public boolean moveNext() {
						this.i++;
						return this.i <= (long) Integer.MAX_VALUE + 2L;
					}
				};

		Predicate<Long> predicate = n -> 1 <= n;
		long expected = (long) Integer.MAX_VALUE + 2L;

		long actual = source.longCount(predicate);
		Assert.assertEquals(expected, actual);
	}
}
