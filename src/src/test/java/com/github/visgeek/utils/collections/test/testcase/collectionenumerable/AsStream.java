package com.github.visgeek.utils.collections.test.testcase.collectionenumerable;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class AsStream {
	@Test
	public void case01() {
		IEnumerable<Item> source = Enumerable.of(new ItemCollection(1, 2, 3));
		IEnumerable<Item> items = () -> source.asStream().iterator();
		IEnumerable<Integer> values = items.select(item -> item.value());

		Assert2.assertSequanceEquals(values, 1, 2, 3);
	}
}
