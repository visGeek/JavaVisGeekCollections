package com.github.visgeek.utils.collections.test.testcase.ienumerable;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class DefaultIfEmpty04 {
	@Test
	public void notEmpty() {
		IEnumerable<Integer> values = Enumerable.of(1, 2, 3);
		Integer[] defaultValues = new Integer[] { 4, 5, 6 };

		IEnumerable<Integer> actual = values.defaultIfEmpty(defaultValues);
		Assert2.assertSequanceEquals(actual, 1, 2, 3);
	}

	@Test
	public void empty() {
		IEnumerable<Integer> values = Enumerable.empty();
		Integer[] defaultValues = new Integer[] { 4, 5, 6 };

		IEnumerable<Integer> actual = values.defaultIfEmpty(defaultValues);
		Assert2.assertSequanceEquals(actual, 4, 5, 6);
	}
}
