package com.github.visgeek.utils.collections.test.testcase.ireadonlylist;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class Last {
	@Rule
	public final ExpectedException expectedException = ExpectedException.none();

	@Test
	public void empty() {
		this.expectedException.expect(UnsupportedOperationException.class);

		Integer[] source = new Integer[] {};

		TestList<Integer> collection = new TestList<>(source);
		collection.last();
	}

	@Test
	public void any() {
		Integer[] source = new Integer[] { 1, 2, 3 };
		Integer expected = 3;

		TestList<Integer> collection = new TestList<>(source);
		Integer actual = collection.last();
		Assert.assertEquals(expected, actual);
	}
}
