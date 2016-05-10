package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.Func1;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class SkipWhile01 {
	@Test
	public void argIsNull() {
		IEnumerable<Integer> source = () -> Enumerable.empty(Integer.class).iterator();
		Func1<Integer, Boolean> predicate = null;

		Action0 action = () -> source.skipWhile(predicate);
		Assert2.assertNullPointerExceptionThrown("predicate", action);
	}

	@Test
	public void unmatchAll() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, 3, 4).iterator();
		Func1<Integer, Boolean> predicate = n -> n == 0;
		Integer[] expected = new Integer[] { 1, 2, 3, 4 };

		IEnumerable<Integer> actual = source.skipWhile(predicate);
		Assert2.assertSequanceEquals(actual, expected);
	}

	@Test
	public void matchAll() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, 3, 4).iterator();
		Func1<Integer, Boolean> predicate = n -> n <= 4;
		Integer[] expected = new Integer[] {};

		IEnumerable<Integer> actual = source.skipWhile(predicate);
		Assert2.assertSequanceEquals(actual, expected);
	}

	@Test
	public void matchPartical() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, 3, 4, 3, 2, 1).iterator();
		Func1<Integer, Boolean> predicate = n -> n <= 2;
		Integer[] expected = new Integer[] { 3, 4, 3, 2, 1 };

		IEnumerable<Integer> actual = source.skipWhile(predicate);
		Assert2.assertSequanceEquals(actual, expected);
	}
}
