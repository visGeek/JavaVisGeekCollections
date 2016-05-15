package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import java.util.Arrays;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.functions.Action0;
import com.github.visgeek.utils.functions.Func1;
import com.github.visgeek.utils.testing.Assert2;

public class SelectMany01 {
	@Test
	public void argIsNull() {
		IEnumerable<Item> source = Enumerable.empty();
		Func1<Item, Iterable<Integer>> selector = null;

		Action0 action = () -> source.selectMany(selector);
		Assert2.assertNullPointerExceptionThrown("selector", action);
	}

	@Test
	public void test() {
		IEnumerable<Item> source = () -> Enumerable.of(new Item(1, 2, 3), new Item(4, 5, 6), new Item(7, 8, 9)).iterator();
		Func1<Item, Iterable<Integer>> selector = item -> item.values;
		IEnumerable<Integer> expected = Enumerable.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

		IEnumerable<Integer> actual = source.selectMany(selector);
		Assert2.assertSequanceEquals(actual, expected);
	}

	private static class Item {
		public Item(Integer... values) {
			this.values = Arrays.asList(values);
		}

		public final Iterable<Integer> values;
	}
}
