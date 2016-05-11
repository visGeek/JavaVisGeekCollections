package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances.collectionenumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;

public class Contains {
	@Test
	public void iterableContains() {
		IEnumerable<Item> source = Enumerable.of(new ItemCollection(1, 2, 3));
		Item target = new Item(2);
		boolean expected = true;

		boolean actual = source.contains(target);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void iterableNotContains() {
		IEnumerable<Item> source = Enumerable.of(new ItemCollection(1, 2, 3));
		Item target = new Item(4);
		boolean expected = false;

		boolean actual = source.contains(target);
		Assert.assertEquals(expected, actual);
	}
}
