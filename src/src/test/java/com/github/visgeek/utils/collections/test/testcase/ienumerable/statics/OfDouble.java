package com.github.visgeek.utils.collections.test.testcase.ienumerable.statics;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class OfDouble {
	@Test
	public void primitiveArray_empty() {
		double[] values = new double[] {};
		IEnumerable<Double> actual = Enumerable.of(values);

		Assert2.assertSequanceEquals(actual);
	}

	@Test
	public void primitiveArray_normal() {
		double[] values = new double[] { 1.0, 2.0, 3.0 };
		IEnumerable<Double> actual = Enumerable.of(values);

		Assert2.assertSequanceEquals(actual, 1.0, 2.0, 3.0);
	}

	@Test
	public void objectArray_empty() {
		Double[] values = new Double[] {};
		IEnumerable<Double> actual = Enumerable.of(values);

		Assert2.assertSequanceEquals(actual);
	}

	@Test
	public void objectArray_normal() {
		Double[] values = new Double[] { 1.0, 2.0, 3.0 };
		IEnumerable<Double> actual = Enumerable.of(values);

		Assert2.assertSequanceEquals(actual, 1.0, 2.0, 3.0);
	}

	@Test
	public void iterable_empty() {
		List<Double> values = new ArrayList<>();
		IEnumerable<Double> actual = Enumerable.ofDouble(values);

		Assert2.assertSequanceEquals(actual);
	}

	@Test
	public void iterable_normal() {
		List<Double> values = new ArrayList<>();
		values.add(1.0);
		values.add(2.0);
		values.add(3.0);

		IEnumerable<Double> actual = Enumerable.ofDouble(values);

		Assert2.assertSequanceEquals(actual, 1.0, 2.0, 3.0);
	}
}
