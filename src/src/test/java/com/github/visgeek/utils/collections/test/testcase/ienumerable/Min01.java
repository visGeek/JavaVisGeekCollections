package com.github.visgeek.utils.collections.test.testcase.ienumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class Min01 {
	@Test
	public void empty() {
		IEnumerable<Integer> source = Enumerable.empty(Integer.class);
		Class<? extends Exception> exceptionClass = UnsupportedOperationException.class;
		Action0 action = () -> source.min();
		Assert2.assertExceptionThrown(exceptionClass, action);
	}

	@Test
	public void uncomparable() {
		IEnumerable<Uncomparable> source = () -> Enumerable.of(new Uncomparable(), new Uncomparable(), new Uncomparable()).iterator();
		Class<? extends Exception> exceptionClass = ClassCastException.class;
		Action0 action = () -> source.min();
		Assert2.assertExceptionThrown(exceptionClass, action);
	}

	@Test
	public void normal() {
		IEnumerable<Integer> source = () -> Enumerable.of(2, 1, 3).iterator();
		int expected = 1;
		int actual = source.min();
		Assert.assertEquals(expected, actual);
	}

	private static class Uncomparable {
	}
}
