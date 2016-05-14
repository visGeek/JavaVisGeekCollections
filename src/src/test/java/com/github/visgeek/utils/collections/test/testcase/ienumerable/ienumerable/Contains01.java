package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;

public class Contains01 {
	@Test
	public void iterableContains() {
		Integer[] source = new Integer[] { 1, 2, 3 };
		int target = 2;
		boolean expected = true;

		IEnumerable<Integer> values = () -> Enumerable.of(source).iterator();
		boolean actual = values.contains(target);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void iterableNotContains() {
		Integer[] source = new Integer[] { 1, 2, 3 };
		int target = 4;
		boolean expected = false;

		IEnumerable<Integer> values = () -> Enumerable.of(source).iterator();
		boolean actual = values.contains(target);
		Assert.assertEquals(expected, actual);
	}
}
