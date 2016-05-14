package com.github.visgeek.utils.collections.test.testcase.ireadonlylist;

import org.junit.Assert;
import org.junit.Test;

public class FirstOrDefault {
	@Test
	public void empty() {
		Integer[] source = new Integer[] {};
		Integer defaultValue = 0;
		Integer expected = defaultValue;

		TestList<Integer> collection = new TestList<>(source);
		Integer actual = collection.firstOrDefault(defaultValue);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void any() {
		Integer[] source = new Integer[] { 1, 2, 3 };
		Integer defaultValue = 0;
		Integer expected = 1;

		TestList<Integer> collection = new TestList<>(source);
		Integer actual = collection.firstOrDefault(defaultValue);
		Assert.assertEquals(expected, actual);
	}
}
