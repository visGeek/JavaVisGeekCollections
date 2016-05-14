package com.github.visgeek.utils.collections.test.testcase.readonlycollectionbase;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;

public class ToArray {
	@Test
	public void test() {
		Integer[] source = new Integer[] { 1, 2, 3 };
		Integer[] expected = source;

		IEnumerable<Integer> enumerable = Enumerable.of(source);
		Integer[] actual = enumerable.toArray(Integer.class);
		Assert.assertArrayEquals(expected, actual);
	}
}
