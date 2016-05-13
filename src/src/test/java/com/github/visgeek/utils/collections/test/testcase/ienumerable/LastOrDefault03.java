package com.github.visgeek.utils.collections.test.testcase.ienumerable;

import java.util.function.Predicate;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class LastOrDefault03 {
	@Test
	public void arg1IsNull() {
		IEnumerable<Integer> source = Enumerable.empty(Integer.class);
		Predicate<Integer> predicate = null;
		Action0 action = () -> source.lastOrDefault(predicate);
		Assert2.assertNullPointerExceptionThrown("predicate", action);
	}

	@Test
	public void empty() {
		IEnumerable<Integer> source = Enumerable.empty();
		Predicate<Integer> predicate = n -> n <= 2;
		Integer expected = null;

		Integer actual = source.lastOrDefault(predicate);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void found() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, 3).iterator();
		Predicate<Integer> predicate = n -> 2 <= n;
		Integer expected = 3;

		Integer actual = source.lastOrDefault(predicate);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void notFound() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, 3).iterator();
		Predicate<Integer> predicate = n -> 4 <= n;
		Integer expected = null;

		Integer actual = source.lastOrDefault(predicate);
		Assert.assertEquals(expected, actual);
	}
}
