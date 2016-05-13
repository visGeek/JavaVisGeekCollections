package com.github.visgeek.utils.collections.test.testcase.ienumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;

public class IndexOf01 {
	@Test
	public void found() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, 3).iterator();
		Integer target = 2;
		int expected = 1;
		int actual = source.findIndex(target);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void notFound01() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, 3).iterator();
		Integer target = 0;
		int expected = -1;
		int actual = source.findIndex(target);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void notFound02() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, 3).iterator();
		Integer target = 4;
		int expected = -1;
		int actual = source.findIndex(target);
		Assert.assertEquals(expected, actual);
	}
}
