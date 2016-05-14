package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import java.util.function.Predicate;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class Single02 {
	@Test
	public void argIsNull() {
		IEnumerable<Integer> source = Enumerable.empty(Integer.class);
		Predicate<Integer> predicate = null;

		Action0 action = () -> source.single(predicate);
		Assert2.assertNullPointerExceptionThrown("predicate", action);
	}

	@Test
	public void notFound() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 3, 4).iterator();
		Predicate<Integer> predicate = n -> n == 2;

		Action0 action = () -> source.single(predicate);
		Assert2.assertExceptionThrown(UnsupportedOperationException.class, action);
	}

	@Test
	public void towOrOrver() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, 2, 3, 4).iterator();
		Predicate<Integer> predicate = n -> n == 2;

		Action0 action = () -> source.single(predicate);
		Assert2.assertExceptionThrown(UnsupportedOperationException.class, action);
	}

	@Test
	public void success() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, 3, 4).iterator();
		Predicate<Integer> predicate = n -> n == 2;
		int expected = 2;

		int actual = source.single(predicate);
		Assert.assertEquals(expected, actual);
	}
}
