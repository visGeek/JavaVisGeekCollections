package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances.icollectionenumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;

public class Contains {
	@Test
	public void any() {
		IEnumerable<Item> source = Enumerable.of(new ItemCollection(1, 2, 3));
		boolean expected = true;

		boolean actual = source.any();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void empty() {
		IEnumerable<Item> source = Enumerable.of(new ItemCollection());
		boolean expected = false;

		boolean actual = source.any();
		Assert.assertEquals(expected, actual);
	}
}
