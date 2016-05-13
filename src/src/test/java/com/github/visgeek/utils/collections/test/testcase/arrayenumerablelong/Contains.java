package com.github.visgeek.utils.collections.test.testcase.arrayenumerablelong;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;

public class Contains {
	@Test
	public void contains() {
		IEnumerable<Long> source = Enumerable.of(1L, 2L, 3L);
		Long target = 2L;
		boolean expected = true;

		boolean actual = source.contains(target);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void notContains() {
		IEnumerable<Long> source = Enumerable.of(1L, 2L, 3L);
		Long target = 4L;
		boolean expected = false;

		boolean actual = source.contains(target);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void argIsNull() {
		IEnumerable<Long> source = Enumerable.of(1L, 2L, 3L);
		Long target = null;
		boolean expected = false;

		boolean actual = source.contains(target);
		Assert.assertEquals(expected, actual);
	}
}
