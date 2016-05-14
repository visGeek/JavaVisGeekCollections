package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.IEnumerable;

public class AverageInteger {
	@Test
	public void test() {
		Integer[] source = new Integer[] { null, 1, 2, 3 };
		Double expected = (double) (1 + 2 + 3) / 3;

		IEnumerable<Integer> enumerable = () -> Arrays.asList(source).iterator();
		Double actual = enumerable.averageInteger(n -> n);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void empty() {
		Integer[] source = new Integer[] {};
		Double expected = null;

		IEnumerable<Integer> enumerable = () -> Arrays.asList(source).iterator();
		Double actual = enumerable.averageInteger(n -> n);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void nullAll() {
		Integer[] source = new Integer[] { null, null, null };
		Double expected = null;

		IEnumerable<Integer> enumerable = () -> Arrays.asList(source).iterator();
		Double actual = enumerable.averageInteger(n -> n);
		Assert.assertEquals(expected, actual);
	}
}
