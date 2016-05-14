package com.github.visgeek.utils.collections.test.testcase.ireadonlycollection;

import org.junit.Assert;
import org.junit.Test;

public class Count {
	@Test
	public void empty() {
		Integer[] source = new Integer[] {};
		int expected = source.length;

		TestCollection<Integer> collection = new TestCollection<>(source);
		int actual = collection.count();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void any() {
		Integer[] source = new Integer[] { 1, 2, 3 };
		int expected = source.length;

		TestCollection<Integer> collection = new TestCollection<>(source);
		int actual = collection.count();
		Assert.assertEquals(expected, actual);
	}
}
