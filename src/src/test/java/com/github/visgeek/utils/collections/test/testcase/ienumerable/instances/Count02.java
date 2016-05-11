package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.Func1;
import com.github.visgeek.utils.collections.AbstractEnumerator;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class Count02 {
	@Test
	public void predicteIsNull() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, 3).iterator();
		Func1<Integer, Boolean> predicate = null;

		Action0 action = () -> source.count(predicate);
		Assert2.assertNullPointerExceptionThrown("predicate", action);
	}

	@Test
	public void test01() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, 3).iterator();
		Func1<Integer, Boolean> predicate = n -> n <= 2;
		int expected = 2;

		int actual = source.count(predicate);
		Assert.assertEquals(actual, expected);
	}

	@Test
	@Ignore
	public void overflow() {
		IEnumerable<Integer> source =
				() -> new AbstractEnumerator<Integer>() {
					private int i = -20;

					@Override
					public Integer current() {
						return this.i;
					}

					@Override
					public boolean moveNext() {
						this.i++;
						return this.i <= Integer.MAX_VALUE;
					}
				};

		Func1<Integer, Boolean> predicate = n -> 10 <= n;

		Action0 action = () -> source.count(predicate);
		Assert2.assertExceptionThrown(ArithmeticException.class, action);
	}
}
