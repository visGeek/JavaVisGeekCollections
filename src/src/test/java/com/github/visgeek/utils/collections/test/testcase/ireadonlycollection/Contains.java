package com.github.visgeek.utils.collections.test.testcase.ireadonlycollection;

import org.junit.Assert;
import org.junit.Test;

public class Contains {
	@Test
	public void contains() {
		Integer[] source = new Integer[] { 1, 2, 3 };
		Integer target = 2;
		boolean expected = true;

		TestCollection<Integer> collection = new TestCollection<>(source);
		boolean actual = collection.contains(target);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void notContains() {
		Integer[] source = new Integer[] { 1, 2, 3 };
		Integer target = 4;
		boolean expected = false;

		TestCollection<Integer> collection = new TestCollection<>(source);
		boolean actual = collection.contains(target);
		Assert.assertEquals(expected, actual);
	}
}
