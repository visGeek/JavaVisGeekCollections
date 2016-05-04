package com.github.visgeek.utils.test.testcase.collections.ienumerable.statics;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class AsIntegerEnumerable {
	@Test
	public void test__enumerable_asIntegerEnumerable01_01() {
		int[] values = new int[] {};
		IEnumerable<Integer> actual = Enumerable.ofInteger(values);

		Assert2.assertSequanceEquals(actual);
	}

	@Test
	public void test__enumerable_asIntegerEnumerable01_02() {
		int[] values = new int[] { 1, 2, 3 };
		IEnumerable<Integer> actual = Enumerable.ofInteger(values);

		Assert2.assertSequanceEquals(actual, 1, 2, 3);
	}

	@Test
	public void test__enumerable_asIntegerEnumerable02_01() {
		Integer[] values = new Integer[] {};
		IEnumerable<Integer> actual = Enumerable.ofInteger(values);

		Assert2.assertSequanceEquals(actual);
	}

	@Test
	public void test__enumerable_asIntegerEnumerable02_02() {
		Integer[] values = new Integer[] { 1, 2, 3 };
		IEnumerable<Integer> actual = Enumerable.ofInteger(values);

		Assert2.assertSequanceEquals(actual, 1, 2, 3);
	}

	@Test
	public void test__enumerable_asIntegerEnumerable03_01() {
		List<Integer> values = new ArrayList<>();
		IEnumerable<Integer> actual = Enumerable.ofInteger(values);

		Assert2.assertSequanceEquals(actual);
	}

	@Test
	public void test__enumerable_asIntegerEnumerable03_02() {
		List<Integer> values = new ArrayList<>();
		values.add(1);
		values.add(2);
		values.add(3);

		IEnumerable<Integer> actual = Enumerable.ofInteger(values);

		Assert2.assertSequanceEquals(actual, 1, 2, 3);
	}
}
