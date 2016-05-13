package com.github.visgeek.utils.collections.test.testcase.ienumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.Func1;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.EnumerableMap;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class ToMap01 {
	@Test
	public void keySelectorIsNull() {
		IEnumerable<Item> source = () -> Enumerable.of(new Item[] {}).iterator();
		Func1<Item, String> keySelector = null;

		Action0 action = () -> source.toMap(keySelector);
		Assert2.assertNullPointerExceptionThrown("keySelector", action);
	}

	@Test
	public void keyAlreadExists() {
		IEnumerable<Item> source =
				() -> Enumerable.of(new Item[] {
					new Item("a", 1),
					new Item("a", 2),
				}).iterator();

		Func1<Item, String> keySelector = item -> item.key;

		Action0 action = () -> source.toMap(keySelector);
		Assert2.assertExceptionThrown(IllegalArgumentException.class, action);
	}

	@Test
	public void test() {
		IEnumerable<Item> source =
				() -> Enumerable.of(new Item[] {
					new Item("a", 1),
					new Item("b", 2),
					new Item("c", 3),
				}).iterator();

		Func1<Item, String> keySelector = item -> item.key;

		EnumerableMap<String, Item> actual = source.toMap(keySelector);

		Assert.assertEquals(actual.size(), 3);
		equalse(actual, "a", 1);
		equalse(actual, "b", 2);
		equalse(actual, "c", 3);
	}

	private void equalse(EnumerableMap<String, Item> map, String key, int value) {
		Assert.assertEquals(value, map.getValue(key).value);
	}

	private static class Item {
		public Item(String key, int value) {
			this.key = key;
			this.value = value;
		}

		public final String key;

		public final int value;
	}
}
