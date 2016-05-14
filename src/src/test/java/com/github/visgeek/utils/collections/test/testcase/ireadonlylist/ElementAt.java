package com.github.visgeek.utils.collections.test.testcase.ireadonlylist;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ElementAt {
	@Rule
	public final ExpectedException expectedException = ExpectedException.none();

	@Test
	public void testSuccess() {
		Integer[] source = new Integer[] { 1, 2, 3 };
		int index = 1;
		int expected = 2;

		TestList<Integer> collection = new TestList<>(source);
		int actual = collection.elementAt(index);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testIndexOutOfRange01() {
		this.expectedException.expect(IllegalArgumentException.class);

		Integer[] source = new Integer[] { 1, 2, 3 };
		int index = -1;

		TestList<Integer> collection = new TestList<>(source);
		collection.elementAt(index);
	}

	@Test
	public void testIndexOutOfRange02() {
		this.expectedException.expect(IllegalArgumentException.class);

		Integer[] source = new Integer[] { 1, 2, 3 };
		int index = 4;

		TestList<Integer> collection = new TestList<>(source);
		collection.elementAt(index);
	}
}
