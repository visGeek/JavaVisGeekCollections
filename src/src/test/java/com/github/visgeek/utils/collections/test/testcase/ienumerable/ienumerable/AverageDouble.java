package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.IEnumerable;

public class AverageDouble {
	@Test
	public void test() {
		Double[] source = new Double[] { null, 1.0, 2.0, 3.0, 4.0 };
		Double expected = (1.0 + 2.0 + 3.0 + 4.0) / 4;

		IEnumerable<Double> enumerable = () -> Arrays.asList(source).iterator();
		Double actual = enumerable.averageDouble(n -> n);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void empty() {
		Double[] source = new Double[] {};
		Double expected = null;

		IEnumerable<Double> enumerable = () -> Arrays.asList(source).iterator();
		Double actual = enumerable.averageDouble(n -> n);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void nullAll() {
		Double[] source = new Double[] { null, null, null };
		Double expected = null;

		IEnumerable<Double> enumerable = () -> Arrays.asList(source).iterator();
		Double actual = enumerable.averageDouble(n -> n);
		Assert.assertEquals(expected, actual);
	}
}
