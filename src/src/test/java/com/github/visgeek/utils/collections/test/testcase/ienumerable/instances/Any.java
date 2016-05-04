package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;

public class Any {
	@Test
	public void test_any01_01() {
		boolean actual = Enumerable.of(1, 2).any();
		Assert.assertTrue(actual);
	}

	@Test
	public void test_any01_02() {
		boolean actual = Enumerable.of().any();
		Assert.assertFalse(actual);
	}

	@Test
	public void test_any02_01() {
		boolean actual = Enumerable.of(1, 2, 3).any(n -> n == 2);
		Assert.assertTrue(actual);
	}

	@Test
	public void test_any02_02() {
		boolean actual = Enumerable.of(1, 2, 3).any(n -> n == 4);
		Assert.assertFalse(actual);
	}
}
