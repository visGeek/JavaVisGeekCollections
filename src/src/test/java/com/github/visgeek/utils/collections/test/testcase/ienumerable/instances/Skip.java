package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class Skip {
	@Test
	public void argIsNegative() {
		IEnumerable<Integer> source = () -> Enumerable.empty(Integer.class).iterator();
		int count = -1;

		Action0 action = () -> source.skip(count);
		Assert2.assertExceptionThrown(IllegalArgumentException.class, action);
	}

	@Test
	public void argIsZero() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, 3, 4).iterator();
		int count = 0;
		Integer[] expected = new Integer[] { 1, 2, 3, 4 };

		IEnumerable<Integer> actual = source.skip(count);
		Assert2.assertSequanceEquals(actual, expected);
	}

	@Test
	public void argIsOne() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, 3, 4).iterator();
		int count = 1;
		Integer[] expected = new Integer[] { 2, 3, 4 };

		IEnumerable<Integer> actual = source.skip(count);
		Assert2.assertSequanceEquals(actual, expected);
	}

	@Test
	public void argIsTowOrOver() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, 3, 4).iterator();
		int count = 2;
		Integer[] expected = new Integer[] { 3, 4 };

		IEnumerable<Integer> actual = source.skip(count);
		Assert2.assertSequanceEquals(actual, expected);
	}

	@Test
	public void argIsElementCountOver() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, 3, 4).iterator();
		int count = 5;
		Integer[] expected = new Integer[] {};

		IEnumerable<Integer> actual = source.skip(count);
		Assert2.assertSequanceEquals(actual, expected);
	}
}
