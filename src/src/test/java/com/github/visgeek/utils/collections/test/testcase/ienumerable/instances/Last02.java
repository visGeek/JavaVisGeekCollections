package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.Func1;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class Last02 {
	@Test
	public void arg1IsNull() {
		IEnumerable<Integer> source = Enumerable.empty(Integer.class);
		Action0 action = () -> source.last(null);
		Assert2.assertNullPointerExceptionThrown("predicate", action);
	}

	@Test
	public void sourceIsEmpty() {
		IEnumerable<Integer> source = Enumerable.empty(Integer.class);
		Func1<Integer, Boolean> predicate = n -> n % 2 == 0;

		Action0 action = () -> source.last(predicate);
		Assert2.assertExceptionThrown(UnsupportedOperationException.class, action);
	}

	@Test
	public void notFound() {
		IEnumerable<Integer> source = Enumerable.empty(Integer.class);
		Func1<Integer, Boolean> predicate = n -> n % 2 == 0;

		Action0 action = () -> source.last(predicate);
		Assert2.assertExceptionThrown(UnsupportedOperationException.class, action);
	}

	@Test
	public void found() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, 3, 4).iterator();
		Func1<Integer, Boolean> predicate = n -> n % 2 == 0;
		int expected = 4;

		int actual = source.last(predicate);
		Assert.assertEquals(expected, actual);
	}
}
