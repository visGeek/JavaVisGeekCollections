package com.github.visgeek.utils.collections.test.testcase.readonlycollectionbase;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;

public class Size {
	@Test
	public void contains() {
		Integer[] source = new Integer[] { 1, 2, 3 };
		int expected = source.length;

		int actual = Enumerable.of(source).count();
		Assert.assertEquals(expected, actual);
	}
}
