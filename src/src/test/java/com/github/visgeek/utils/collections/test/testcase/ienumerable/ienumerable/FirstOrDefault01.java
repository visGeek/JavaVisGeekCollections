package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;

public class FirstOrDefault01 {
	@Test
	public void empty() {
		IEnumerable<Integer> source = Enumerable.empty();
		Integer expected = null;

		Integer actual = source.firstOrDefault();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void any() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, 3).iterator();
		Integer expected = 1;

		Integer actual = source.firstOrDefault();
		Assert.assertEquals(expected, actual);
	}
}
