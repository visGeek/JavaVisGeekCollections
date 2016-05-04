package com.github.visgeek.utils.test.testcase.collections.ienumerable.instances;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class DefaultIfEmpty01 {
	@Test
	public void notEmpty() {
		IEnumerable<Integer> values = Enumerable.of(1, 2, 3);
		// デフォルト値はなし

		IEnumerable<Integer> actual = values.defaultIfEmpty();
		Assert2.assertSequanceEquals(actual, 1, 2, 3);
	}

	@Test
	public void empty() {
		IEnumerable<Integer> values = Enumerable.empty();
		// デフォルト値はなし

		IEnumerable<Integer> actual = values.defaultIfEmpty();
		Assert2.assertSequanceEquals(actual, (Integer) null);
	}
}
