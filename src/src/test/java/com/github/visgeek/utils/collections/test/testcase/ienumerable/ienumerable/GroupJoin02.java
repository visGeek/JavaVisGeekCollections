package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.Func1;
import com.github.visgeek.utils.Func2;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.collections.IReadOnlyList;
import com.github.visgeek.utils.testing.Assert2;

public class GroupJoin02 {
	@Test
	public void arg1IsNull() {
		IEnumerable<String> keys = Enumerable.empty();
		IEnumerable<Item> values = null;
		Func1<String, String> outerKeySelector = key -> key;
		Func1<Item, String> innerKeySelector = item -> item.key;
		Func2<String, IEnumerable<Item>, ResultItems> resultSelector = (key, items) -> new ResultItems(key, items);
		Action0 action = () -> keys.groupJoin(values, outerKeySelector, innerKeySelector, resultSelector);
		Assert2.assertNullPointerExceptionThrown("inner", action);
	}

	@Test
	public void arg2IsNull() {
		IEnumerable<String> keys = Enumerable.empty();
		IEnumerable<Item> values = Enumerable.empty();
		Func1<String, String> outerKeySelector = null;
		Func1<Item, String> innerKeySelector = item -> item.key;
		Func2<String, IEnumerable<Item>, ResultItems> resultSelector = (key, items) -> new ResultItems(key, items);
		Action0 action = () -> keys.groupJoin(values, outerKeySelector, innerKeySelector, resultSelector);
		Assert2.assertNullPointerExceptionThrown("outerKeySelector", action);
	}

	@Test
	public void arg3IsNull() {
		IEnumerable<String> keys = Enumerable.empty();
		IEnumerable<Item> values = Enumerable.empty();
		Func1<String, String> outerKeySelector = key -> key;
		Func1<Item, String> innerKeySelector = null;
		Func2<String, IEnumerable<Item>, ResultItems> resultSelector = (key, items) -> new ResultItems(key, items);
		Action0 action = () -> keys.groupJoin(values, outerKeySelector, innerKeySelector, resultSelector);
		Assert2.assertNullPointerExceptionThrown("innerKeySelector", action);
	}

	@Test
	public void arg4IsNull() {
		IEnumerable<String> keys = Enumerable.empty();
		IEnumerable<Item> values = Enumerable.empty();
		Func1<String, String> outerKeySelector = key -> key;
		Func1<Item, String> innerKeySelector = item -> item.key;
		Func2<String, IEnumerable<Item>, ResultItems> resultSelector = null;
		Action0 action = () -> keys.groupJoin(values, outerKeySelector, innerKeySelector, resultSelector);
		Assert2.assertNullPointerExceptionThrown("resultSelector", action);
	}

	@Test
	public void test01() {
		IEnumerable<String> keys = Enumerable.of("1", "2", "3");
		IEnumerable<Item> values = Enumerable.of(new Item[] {
			new Item("1", 1),
			new Item("2", 1),
			new Item("2", 2),
			new Item("1", 2),
			new Item("1", 3),
			new Item("4", 1),
		});

		Func2<String, IEnumerable<Item>, ResultItems> resultSelector = (key, items) -> new ResultItems(key, items);

		IReadOnlyList<ResultItems> actual =
				keys
						.groupJoin(values, key -> key, value -> value.key, resultSelector)
						.toList();

		Assert.assertEquals(3, actual.size());

		assertEquals(actual.get(0), "1", 1, 2, 3);
		assertEquals(actual.get(1), "2", 1, 2);
		assertEquals(actual.get(2), "3");
	}

	private void assertEquals(ResultItems resultItems, String key, Integer... values) {
		Assert.assertEquals(resultItems.key, key);
		Assert2.assertSequanceEquals(resultItems.items.select(val -> val.value), values);
	}

	private static class Item {
		Item(String key, int value) {
			this.key = key;
			this.value = value;
		}

		public final String key;

		public final int value;
	}

	private static class ResultItems {
		ResultItems(String key, IEnumerable<Item> items) {
			this.key = key;
			this.items = items;
		}

		public final String key;

		public final IEnumerable<Item> items;
	}
}
