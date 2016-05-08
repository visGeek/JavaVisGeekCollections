package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;

public class ToArray {
	@Test
	public void test_toArray() {
		Integer[] actual = Enumerable.of(1, 2, 3).toArray(Integer.class);
		Assert.assertArrayEquals(actual, new Integer[] { 1, 2, 3 });
	}

	@Test
	public void test_toDoubleArray() {
		double[] actual = Enumerable.of(1.0, 2.0, 3.0).toDoubleArray();
		Assert.assertArrayEquals(actual, new double[] { 1.0, 2.0, 3.0 }, 0);
	}

	@Test
	public void test_toIntArray() {
		int[] actual = Enumerable.of(1, 2, 3).toIntArray();
		Assert.assertArrayEquals(actual, new int[] { 1, 2, 3 });
	}

	@Test
	public void test_toLongArray() {
		long[] actual = Enumerable.of(1L, 2L, 3L).toLongArray();
		Assert.assertArrayEquals(actual, new long[] { 1L, 2L, 3L });
	}
}
