package com.github.visgeek.utils.test.testcase.collections.ienumerable.instances;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;

public class All {
	@Test
	public void test_all01() {
		boolean actual = Enumerable.of(1, 2, 3).all(n -> 1 <= n && n <= 3);
		Assert.assertTrue(actual);
	}

	@Test
	public void test_all02() {
		boolean actual = Enumerable.of(1, 2, 3).all(n -> 1 <= n && n <= 2);
		Assert.assertFalse(actual);
	}
}
