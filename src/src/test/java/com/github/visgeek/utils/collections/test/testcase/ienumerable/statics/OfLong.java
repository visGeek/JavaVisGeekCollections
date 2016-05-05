package com.github.visgeek.utils.collections.test.testcase.ienumerable.statics;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class OfLong {
	@Test
	public void test__enumerable_asLongEnumerable01_01() {
		long[] values = new long[] {};
		IEnumerable<Long> actual = Enumerable.ofLong(values);

		Assert2.assertSequanceEquals(actual);
	}

	@Test
	public void test__enumerable_asLongEnumerable01_02() {
		long[] values = new long[] { 1L, 2L, 3L };
		IEnumerable<Long> actual = Enumerable.ofLong(values);

		Assert2.assertSequanceEquals(actual, 1L, 2L, 3L);
	}

	@Test
	public void test__enumerable_asLongEnumerable02_01() {
		Long[] values = new Long[] {};
		IEnumerable<Long> actual = Enumerable.ofLong(values);

		Assert2.assertSequanceEquals(actual);
	}

	@Test
	public void test__enumerable_asLongEnumerable02_02() {
		Long[] values = new Long[] { 1L, 2L, 3L };
		IEnumerable<Long> actual = Enumerable.ofLong(values);

		Assert2.assertSequanceEquals(actual, 1L, 2L, 3L);
	}

	@Test
	public void test__enumerable_asLongEnumerable03_01() {
		List<Long> values = new ArrayList<>();
		IEnumerable<Long> actual = Enumerable.ofLong(values);

		Assert2.assertSequanceEquals(actual);
	}

	@Test
	public void test__enumerable_asLongEnumerable03_02() {
		List<Long> values = new ArrayList<>();
		values.add(1L);
		values.add(2L);
		values.add(3L);

		IEnumerable<Long> actual = Enumerable.ofLong(values);

		Assert2.assertSequanceEquals(actual, 1L, 2L, 3L);
	}
}
