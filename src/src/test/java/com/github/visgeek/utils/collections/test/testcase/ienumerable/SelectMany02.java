package com.github.visgeek.utils.collections.test.testcase.ienumerable;

import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.IndexedFunc1;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.EnumerableList;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class SelectMany02 {
	@Test
	public void argIsNull() {
		IEnumerable<Item> source = Enumerable.empty();
		IndexedFunc1<Item, Iterable<Integer>> selector = null;

		Action0 action = () -> source.selectMany(selector);
		Assert2.assertNullPointerExceptionThrown("selector", action);
	}

	@Test
	public void test() {
		IEnumerable<Item> source = () -> Enumerable.of(new Item(1, 2, 3), new Item(4, 5, 6), new Item(7, 8, 9)).iterator();
		IndexedFunc1<Item, Iterable<String>> selector = (item, idx) -> item.values.select(val -> String.format("%s:%s", idx, val));
		IEnumerable<String> expected = Enumerable.of("0:1", "0:2", "0:3", "1:4", "1:5", "1:6", "2:7", "2:8", "2:9");

		IEnumerable<String> actual = source.selectMany(selector);
		Assert2.assertSequanceEquals(actual, expected);
	}

	private static class Item {
		public Item(Integer... values) {
			this.values = new EnumerableList<>(values);
		}

		public final IEnumerable<Integer> values;
	}
}
