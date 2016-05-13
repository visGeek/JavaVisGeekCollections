package com.github.visgeek.utils.collections.test.testcase.ienumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;

public class Empty {
	@Test
	public void test_empty01() {
		Assert.assertTrue(Enumerable.empty(Integer.class).toList().isEmpty());
	}
}
