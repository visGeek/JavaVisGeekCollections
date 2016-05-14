package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.EnumerableList;
import com.github.visgeek.utils.collections.EnumerableSet;
import com.github.visgeek.utils.collections.IEnumerable;

public class ToHashSet {
	@Test
	public void sourceIsCollection() {
		EnumerableList<Integer> source = new EnumerableList<>(Arrays.asList(1, 2, 3, 1, 2, 3));
		Integer[] expected = new Integer[] { 1, 2, 3 };

		EnumerableSet<Integer> actual = source.toHashSet();
		Assert.assertEquals(expected.length, actual.size());

		for (Integer val : expected) {
			Assert.assertTrue(actual.containsValue(val));
		}
	}

	@Test
	public void sourceIsIterable() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, 3, 1, 2, 3).iterator();
		Integer[] expected = new Integer[] { 1, 2, 3 };

		EnumerableSet<Integer> actual = source.toHashSet();
		Assert.assertEquals(expected.length, actual.size());

		for (Integer val : expected) {
			Assert.assertTrue(actual.containsValue(val));
		}
	}
}
