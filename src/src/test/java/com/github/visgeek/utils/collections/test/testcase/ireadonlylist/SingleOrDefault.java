package com.github.visgeek.utils.collections.test.testcase.ireadonlylist;

import org.junit.Assert;
import org.junit.Test;

public class SingleOrDefault {
	@Test
	public void empty() {
		Integer[] source = new Integer[] {};
		Integer defaultValue = 0;
		Integer expected = defaultValue;

		TestList<Integer> collection = new TestList<>(source);
		Integer actual = collection.singleOrDefault(defaultValue);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void towOrOrver() {
		Integer[] source = new Integer[] { 1, 2, 3 };
		Integer defaultValue = 0;
		Integer expected = defaultValue;

		TestList<Integer> collection = new TestList<>(source);
		Integer actual = collection.singleOrDefault(defaultValue);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void success() {
		Integer[] source = new Integer[] { 1 };
		Integer defaultValue = 0;
		Integer expected = 1;

		TestList<Integer> collection = new TestList<>(source);
		Integer actual = collection.singleOrDefault(defaultValue);
		Assert.assertEquals(expected, actual);
	}
}
