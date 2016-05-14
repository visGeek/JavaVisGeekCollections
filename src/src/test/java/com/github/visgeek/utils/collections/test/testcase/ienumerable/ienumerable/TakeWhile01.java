package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import java.util.function.Predicate;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.collections.IEnumerator;
import com.github.visgeek.utils.testing.Assert2;

public class TakeWhile01 {
	@Test
	public void argIsNull() {
		IEnumerable<Integer> source = () -> Enumerable.empty(Integer.class).iterator();
		Predicate<Integer> predicate = null;

		Action0 action = () -> source.takeWhile(predicate);
		Assert2.assertNullPointerExceptionThrown("predicate", action);
	}

	@Test
	public void unmatchAll() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, 3, 4).iterator();
		Predicate<Integer> predicate = n -> n == 0;
		Integer[] expected = new Integer[] {};

		IEnumerable<Integer> actual = source.takeWhile(predicate);
		Assert2.assertSequanceEquals(actual, expected);
	}

	@Test
	public void matchAll() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, 3, 4).iterator();
		Predicate<Integer> predicate = n -> n <= 4;
		Integer[] expected = new Integer[] { 1, 2, 3, 4 };

		IEnumerable<Integer> actual = source.takeWhile(predicate);
		Assert2.assertSequanceEquals(actual, expected);
	}

	@Test
	public void matchPartical() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, 3, 4, 3, 2, 1).iterator();
		Predicate<Integer> predicate = n -> n <= 2;
		Integer[] expected = new Integer[] { 1, 2 };

		IEnumerable<Integer> actual = source.takeWhile(predicate);
		Assert2.assertSequanceEquals(actual, expected);
	}

	@Test
	public void enumeration() {
		IEnumerable<Integer> source = () -> Enumerable.of(0, 2).iterator();
		Predicate<Integer> predicate = n -> n <= 0;

		IEnumerable<Integer> actual = source.takeWhile(predicate);
		IEnumerator<Integer> e = actual.getEnumerator();

		Assert.assertTrue(e.moveNext());
		Assert.assertFalse(e.moveNext());
		Assert.assertFalse(e.moveNext());
	}
}
