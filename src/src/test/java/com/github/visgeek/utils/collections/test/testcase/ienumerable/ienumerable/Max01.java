package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.CollectionCreator;

public class Max01 {
	@Rule
	public final ExpectedException expectedException = ExpectedException.none();

	@Test
	public void empty() {
		Integer[] source = new Integer[] {};
		Integer expected = null;

		IEnumerable<Integer> enumerable = () -> CollectionCreator.iterator(source);
		Integer actual = enumerable.max();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void uncomparable() {
		this.expectedException.expect(IllegalArgumentException.class);

		Object[] source = new Object[] { new Object(), new Object(), new Object() };

		IEnumerable<Object> enumerable = () -> CollectionCreator.iterator(source);
		enumerable.max();
	}

	@Test
	public void normal() {
		Integer[] source = new Integer[] { 2, 1, null, 3 };
		Integer expected = 3;

		IEnumerable<Integer> enumerable = () -> CollectionCreator.iterator(source);
		Integer actual = enumerable.max();
		Assert.assertEquals(expected, actual);
	}
}
