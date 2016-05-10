package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.Func1;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class LastOrDefault03 {
	@Test
	public void arg1IsNull() {
		IEnumerable<Integer> source = Enumerable.empty(Integer.class);
		Func1<Integer, Boolean> predicate = null;
		Action0 action = () -> source.lastOrDefault(predicate);
		Assert2.assertNullPointerExceptionThrown("predicate", action);
	}

	@Test
	public void empty() {
		IEnumerable<Integer> source = Enumerable.empty();
		Func1<Integer, Boolean> predicate = n -> n <= 2;
		Integer expected = null;

		Integer actual = source.lastOrDefault(predicate);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void found() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, 3).iterator();
		Func1<Integer, Boolean> predicate = n -> 2 <= n;
		Integer expected = 3;

		Integer actual = source.lastOrDefault(predicate);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void notFound() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, 3).iterator();
		Func1<Integer, Boolean> predicate = n -> 4 <= n;
		Integer expected = null;

		Integer actual = source.lastOrDefault(predicate);
		Assert.assertEquals(expected, actual);
	}
}
