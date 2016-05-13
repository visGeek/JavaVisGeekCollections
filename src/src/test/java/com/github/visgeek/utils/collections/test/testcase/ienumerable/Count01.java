package com.github.visgeek.utils.collections.test.testcase.ienumerable;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.collections.AbstractEnumerator;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class Count01 {
	@Test
	public void test01() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, 3).iterator();
		int actual = source.count();
		int expected = 3;

		Assert.assertEquals(actual, expected);
	}

	@Test
	@Ignore
	public void overflow() {
		IEnumerable<Integer> source =
				() -> new AbstractEnumerator<Integer>() {
					private int i = -10;

					@Override
					public Integer current() {
						return null;
					}

					@Override
					public boolean moveNext() {
						this.i++;
						return this.i <= Integer.MAX_VALUE;
					}
				};

		Action0 action = () -> source.count();
		Assert2.assertExceptionThrown(ArithmeticException.class, action);
	}
}
