package com.github.visgeek.utils.collections.test.testcase.ireadonlylist;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class Single {
	@Rule
	public final ExpectedException expectedException = ExpectedException.none();

	@Test
	public void empty() {
		this.expectedException.expect(UnsupportedOperationException.class);

		Integer[] source = new Integer[] {};

		TestList<Integer> collection = new TestList<>(source);
		collection.single();
	}

	@Test
	public void towOrOrver() {
		this.expectedException.expect(UnsupportedOperationException.class);

		Integer[] source = new Integer[] { 1, 2, 3 };

		TestList<Integer> collection = new TestList<>(source);
		collection.single();
	}

	@Test
	public void success() {
		Integer[] source = new Integer[] { 1 };
		Integer expected = 1;

		TestList<Integer> collection = new TestList<>(source);
		Integer actual = collection.single();
		Assert.assertEquals(expected, actual);
	}
}
