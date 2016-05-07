package com.github.visgeek.utils.collections.test.testcase.ienumerable.statics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class OfLong {
	@Test
	public void primitiveArray_empty() {
		long[] values = new long[] {};
		IEnumerable<Long> actual = Enumerable.of(values);

		Assert2.assertSequanceEquals(actual);
	}

	@Test
	public void primitiveArray_normal() {
		long[] values = new long[] { 1L, 2L, 3L };
		IEnumerable<Long> actual = Enumerable.of(values);

		Assert2.assertSequanceEquals(actual, 1L, 2L, 3L);
	}

	@Test
	public void objectArray_empty() {
		Long[] values = new Long[] {};
		IEnumerable<Long> actual = Enumerable.of(values);

		Assert2.assertSequanceEquals(actual);
	}

	@Test
	public void objectArray_normal() {
		Long[] values = new Long[] { 1L, 2L, 3L };
		IEnumerable<Long> actual = Enumerable.of(values);

		Assert2.assertSequanceEquals(actual, 1L, 2L, 3L);
	}

	@Test
	public void iterable_empty() {
		List<Long> values = new ArrayList<>();
		IEnumerable<Long> actual = Enumerable.ofLong(values);

		Assert2.assertSequanceEquals(actual);
	}

	@Test
	public void iterable_normal() {
		List<Long> values = Arrays.asList(1L, 2L, 3L);
		IEnumerable<Long> actual = Enumerable.ofLong(values);

		Assert2.assertSequanceEquals(actual, 1L, 2L, 3L);
	}
}
