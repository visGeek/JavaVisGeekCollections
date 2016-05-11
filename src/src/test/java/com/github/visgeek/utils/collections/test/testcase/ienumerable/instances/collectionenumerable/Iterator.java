package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances.collectionenumerable;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class Iterator {
	@Test
	public void test() {
		IEnumerable<Item> source = Enumerable.of(new ItemCollection(1, 2, 3));
		Integer[] expected = new Integer[] { 1, 2, 3 };

		IEnumerable<Integer> actual = source.select(item -> item.value());
		Assert2.assertSequanceEquals(actual, expected);
	}
}
