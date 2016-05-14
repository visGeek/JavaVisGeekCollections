package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.IEnumerable;

public class AverageLong {
	@Test
	public void test() {
		Long[] source = new Long[] { null, 1L, 2L, 3L };
		Double expected = (double) (1L + 2L + 3L) / 3;

		IEnumerable<Long> enumerable = () -> Arrays.asList(source).iterator();
		Double actual = enumerable.averageLong(n -> n);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void empty() {
		Long[] source = new Long[] {};
		Double expected = null;

		IEnumerable<Long> enumerable = () -> Arrays.asList(source).iterator();
		Double actual = enumerable.averageLong(n -> n);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void nullAll() {
		Long[] source = new Long[] { null, null, null };
		Double expected = null;

		IEnumerable<Long> enumerable = () -> Arrays.asList(source).iterator();
		Double actual = enumerable.averageLong(n -> n);
		Assert.assertEquals(expected, actual);
	}
}
