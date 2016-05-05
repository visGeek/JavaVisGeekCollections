package com.github.visgeek.utils.collections.test.testcase.ienumerable.statics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class OfInteger {
	@Test
	public void primitiveArray_empty() {
		int[] values = new int[] {};
		IEnumerable<Integer> actual = Enumerable.ofInteger(values);

		Assert2.assertSequanceEquals(actual);
	}

	@Test
	public void primitiveArray_normal() {
		int[] values = new int[] { 1, 2, 3 };
		IEnumerable<Integer> actual = Enumerable.ofInteger(values);

		Assert2.assertSequanceEquals(actual, 1, 2, 3);
	}

	@Test
	public void objectArray_empty() {
		Integer[] values = new Integer[] {};
		IEnumerable<Integer> actual = Enumerable.ofInteger(values);

		Assert2.assertSequanceEquals(actual);
	}

	@Test
	public void objectArray_normal() {
		Integer[] values = new Integer[] { 1, 2, 3 };
		IEnumerable<Integer> actual = Enumerable.ofInteger(values);

		Assert2.assertSequanceEquals(actual, 1, 2, 3);
	}

	@Test
	public void iterable_empty() {
		List<Integer> values = new ArrayList<>();
		IEnumerable<Integer> actual = Enumerable.ofInteger(values);

		Assert2.assertSequanceEquals(actual);
	}

	@Test
	public void iterable_normal() {
		List<Integer> values = Arrays.asList(1, 2, 3);
		IEnumerable<Integer> actual = Enumerable.ofInteger(values);

		Assert2.assertSequanceEquals(actual, 1, 2, 3);
	}
}
