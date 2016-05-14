package com.github.visgeek.utils.collections.test.testcase.ireadonlycollection;

import org.junit.Assert;
import org.junit.Test;

public class ToArray {
	@Test
	public void test() {
		Integer[] source = new Integer[] { 1, 2, 3 };
		Integer[] expected = new Integer[] { 1, 2, 3 };

		TestCollection<Integer> collection = new TestCollection<>(source);
		Integer[] actual = collection.toArray(Integer.class);
		Assert.assertArrayEquals(actual, expected);
	}
}
