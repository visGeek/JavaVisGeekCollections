package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class Shuffle {
	@Test
	public void empty() {
		IEnumerable<Integer> actual = Enumerable.empty(Integer.class).shift(1);
		Assert2.assertSequanceEquals(actual);
	}

	@Test
	public void countIsZero() {
		IEnumerable<Integer> source = () -> Enumerable.range(0, 4).iterator();
		int count = 0;
		Integer[] expected = new Integer[] { 0, 1, 2, 3 };

		IEnumerable<Integer> actual = source.shift(count);
		Assert2.assertSequanceEquals(actual, expected);
	}

	@Test
	public void countIsPositive01() {
		IEnumerable<Integer> source = () -> Enumerable.range(0, 4).iterator();
		int count = 1;
		Integer[] expected = new Integer[] { 1, 2, 3, 0 };

		IEnumerable<Integer> actual = source.shift(count);
		Assert2.assertSequanceEquals(actual, expected);
	}

	@Test
	public void countIsPositive02() {
		IEnumerable<Integer> source = () -> Enumerable.range(0, 4).iterator();
		int count = 5;
		Integer[] expected = new Integer[] { 1, 2, 3, 0 };

		IEnumerable<Integer> actual = source.shift(count);
		Assert2.assertSequanceEquals(actual, expected);
	}

	@Test
	public void countIsNegative01() {
		IEnumerable<Integer> source = () -> Enumerable.range(0, 4).iterator();
		int count = -1;
		Integer[] expected = new Integer[] { 3, 0, 1, 2 };

		IEnumerable<Integer> actual = source.shift(count);
		Assert2.assertSequanceEquals(actual, expected);
	}

	@Test
	public void countIsNegative02() {
		IEnumerable<Integer> source = () -> Enumerable.range(0, 4).iterator();
		int count = -5;
		Integer[] expected = new Integer[] { 3, 0, 1, 2 };

		IEnumerable<Integer> actual = source.shift(count);
		Assert2.assertSequanceEquals(actual, expected);
	}
}
