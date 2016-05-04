package com.github.visgeek.utils.test.testcase.collections.ienumerable.instances;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class Reverse {
	@Test
	public void test_reverse01() {
		IEnumerable<Integer> actual = Enumerable.of(1, 2, 3).reverse();
		Assert2.assertSequanceEquals(actual, 3, 2, 1);
	}
}
