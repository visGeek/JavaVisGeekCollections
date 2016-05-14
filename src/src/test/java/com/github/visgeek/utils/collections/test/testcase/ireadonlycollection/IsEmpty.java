package com.github.visgeek.utils.collections.test.testcase.ireadonlycollection;

import org.junit.Assert;
import org.junit.Test;

public class IsEmpty {
	@Test
	public void empty() {
		Integer[] source = new Integer[] {};
		boolean expected = true;

		TestCollection<Integer> collection = new TestCollection<>(source);
		boolean actual = collection.isEmpty();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void notEmpty() {
		Integer[] source = new Integer[] { 1, 2, 3 };
		boolean expected = false;

		TestCollection<Integer> collection = new TestCollection<>(source);
		boolean actual = collection.isEmpty();
		Assert.assertEquals(expected, actual);
	}
}
