package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;

public class Any01 {
	@Test
	public void caseIsNotEmpty() {
		boolean actual = Enumerable.of(1, 2).any();
		Assert.assertTrue(actual);
	}

	@Test
	public void caseIsEmpty() {
		boolean actual = Enumerable.empty().any();
		Assert.assertFalse(actual);
	}
}
