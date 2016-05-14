package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;

public class Any01 {
	@Test
	public void caseIsNotEmpty() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2).iterator();
		boolean actual = source.any();
		Assert.assertTrue(actual);
	}

	@Test
	public void caseIsEmpty() {
		IEnumerable<Integer> source = () -> Enumerable.empty(Integer.class).iterator();
		boolean actual = source.any();
		Assert.assertFalse(actual);
	}
}
