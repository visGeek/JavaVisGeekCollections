package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.IndexedPredicate;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.collections.IEnumerator;
import com.github.visgeek.utils.testing.Assert2;

public class TakeWhile02 {
	@Test
	public void argIsNull() {
		IEnumerable<Integer> source = () -> Enumerable.empty(Integer.class).iterator();
		IndexedPredicate<Integer> predicate = null;

		Action0 action = () -> source.takeWhile(predicate);
		Assert2.assertNullPointerExceptionThrown("predicate", action);
	}

	@Test
	public void unmatchAll() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, 3, 4).iterator();
		IndexedPredicate<Integer> predicate = (n, idx) -> (int) n == idx;
		Integer[] expected = new Integer[] {};

		IEnumerable<Integer> actual = source.takeWhile(predicate);
		Assert2.assertSequanceEquals(actual, expected);
	}

	@Test
	public void matchAll() {
		IEnumerable<Integer> source = () -> Enumerable.of(0, 1, 2, 3).iterator();
		IndexedPredicate<Integer> predicate = (n, idx) -> (int) n == idx;
		Integer[] expected = new Integer[] { 0, 1, 2, 3 };

		IEnumerable<Integer> actual = source.takeWhile(predicate);
		Assert2.assertSequanceEquals(actual, expected);
	}

	@Test
	public void matchPartical() {
		IEnumerable<Integer> source = () -> Enumerable.of(0, 1, 0, 3, 4).iterator();
		IndexedPredicate<Integer> predicate = (n, idx) -> (int) n == idx;
		Integer[] expected = new Integer[] { 0, 1 };

		IEnumerable<Integer> actual = source.takeWhile(predicate);
		Assert2.assertSequanceEquals(actual, expected);
	}

	@Test
	public void enumeration() {
		IEnumerable<Integer> source = () -> Enumerable.of(0, 2).iterator();
		IndexedPredicate<Integer> predicate = (n, idx) -> (int) n == idx;

		IEnumerable<Integer> actual = source.takeWhile(predicate);
		IEnumerator<Integer> e = actual.getEnumerator();

		Assert.assertTrue(e.moveNext());
		Assert.assertFalse(e.moveNext());
		Assert.assertFalse(e.moveNext());
	}
}
