package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class DefaultIfEmpty02 {
	@Test
	public void notEmpty() {
		IEnumerable<Integer> values = Enumerable.of(1, 2, 3);
		Integer defaultValue = 0;

		IEnumerable<Integer> actual = values.defaultIfEmpty(defaultValue);
		Assert2.assertSequanceEquals(actual, 1, 2, 3);
	}

	@Test
	public void empty() {
		IEnumerable<Integer> values = Enumerable.empty();
		Integer defaultValue = 0;

		IEnumerable<Integer> actual = values.defaultIfEmpty(defaultValue);
		Assert2.assertSequanceEquals(actual, 0);
	}
}
