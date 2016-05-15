package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.EnumerableMap;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.functions.Action0;
import com.github.visgeek.utils.functions.Func1;
import com.github.visgeek.utils.testing.Assert2;

public class ToMap03 {
	@Test
	public void keySelectorIsNull() {
		IEnumerable<Item> source = () -> Enumerable.of(new Item[] {}).iterator();
		Func1<Item, String> keySelector = null;
		Func1<Item, Integer> valueSelector = item -> item.value;

		Action0 action = () -> source.toMap(keySelector, valueSelector);
		Assert2.assertNullPointerExceptionThrown("keySelector", action);
	}

	@Test
	public void valueSelectorIsNull() {
		IEnumerable<Item> source = () -> Enumerable.of(new Item[] {}).iterator();
		Func1<Item, String> keySelector = item -> item.key;
		Func1<Item, Integer> valueSelector = null;

		Action0 action = () -> source.toMap(keySelector, valueSelector);
		Assert2.assertNullPointerExceptionThrown("valueSelector", action);
	}

	@Test
	public void keyAlreadExists() {
		IEnumerable<Item> source =
				() -> Enumerable.of(new Item[] {
					new Item("a", 1),
					new Item("a", 2),
				}).iterator();

		Func1<Item, String> keySelector = item -> item.key;
		Func1<Item, Integer> valueSelector = item -> item.value;

		Action0 action = () -> source.toMap(keySelector, valueSelector);
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
		Func1<Item, Integer> valueSelector = item -> item.value;

		EnumerableMap<String, Integer> actual = source.toMap(keySelector, valueSelector);

		Assert.assertEquals(actual.size(), 3);
		equalse(actual, "a", 1);
		equalse(actual, "b", 2);
		equalse(actual, "c", 3);
	}

	private void equalse(EnumerableMap<String, Integer> map, String key, int value) {
		Assert.assertEquals((Integer) value, map.getValue(key));
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
