package com.github.visgeek.utils.test.testcase.collections.ienumerable.statics;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class AsDoubleEnumerable {
	@Test
	public void test__enumerable_asDoubleEnumerable01_01() {
		double[] values = new double[] {};
		IEnumerable<Double> actual = Enumerable.ofDouble(values);

		Assert2.assertSequanceEquals(actual);
	}

	@Test
	public void test__enumerable_asDoubleEnumerable01_02() {
		double[] values = new double[] { 1.0, 2.0, 3.0 };
		IEnumerable<Double> actual = Enumerable.ofDouble(values);

		Assert2.assertSequanceEquals(actual, 1.0, 2.0, 3.0);
	}

	@Test
	public void test__enumerable_asDoubleEnumerable02_01() {
		Double[] values = new Double[] {};
		IEnumerable<Double> actual = Enumerable.ofDouble(values);

		Assert2.assertSequanceEquals(actual);
	}

	@Test
	public void test__enumerable_asDoubleEnumerable02_02() {
		Double[] values = new Double[] { 1.0, 2.0, 3.0 };
		IEnumerable<Double> actual = Enumerable.ofDouble(values);

		Assert2.assertSequanceEquals(actual, 1.0, 2.0, 3.0);
	}

	@Test
	public void test__enumerable_asDoubleEnumerable03_01() {
		List<Double> values = new ArrayList<>();
		IEnumerable<Double> actual = Enumerable.ofDouble(values);

		Assert2.assertSequanceEquals(actual);
	}

	@Test
	public void test__enumerable_asDoubleEnumerable03_02() {
		List<Double> values = new ArrayList<>();
		values.add(1.0);
		values.add(2.0);
		values.add(3.0);

		IEnumerable<Double> actual = Enumerable.ofDouble(values);

		Assert2.assertSequanceEquals(actual, 1.0, 2.0, 3.0);
	}
}
