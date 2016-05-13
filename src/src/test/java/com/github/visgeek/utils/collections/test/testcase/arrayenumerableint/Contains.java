package com.github.visgeek.utils.collections.test.testcase.arrayenumerableint;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;

public class Contains {
	@Test
	public void contains() {
		IEnumerable<Integer> source = Enumerable.of(1, 2, 3);
		Integer target = 2;
		boolean expected = true;

		boolean actual = source.contains(target);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void notContains() {
		IEnumerable<Integer> source = Enumerable.of(1, 2, 3);
		Integer target = 4;
		boolean expected = false;

		boolean actual = source.contains(target);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void argIsNull() {
		IEnumerable<Integer> source = Enumerable.of(1, 2, 3);
		Integer target = null;
		boolean expected = false;

		boolean actual = source.contains(target);
		Assert.assertEquals(expected, actual);
	}
}
