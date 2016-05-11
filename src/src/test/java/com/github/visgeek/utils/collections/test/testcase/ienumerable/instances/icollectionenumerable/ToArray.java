package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances.icollectionenumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;

public class ToArray {
	@Test
	public void test() {
		IEnumerable<Item> source = Enumerable.of(new ItemCollection(1, 2, 3));
		Item[] expected = new Item[] { new Item(1), new Item(2), new Item(3) };

		Item[] actual = source.toArray(Item.class);
		Assert.assertArrayEquals(actual, expected);
	}
}
