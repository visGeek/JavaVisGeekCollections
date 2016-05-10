package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.Func1;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class MinInt {
	@Test
	public void argIsNull() {
		IEnumerable<Item> source = Enumerable.empty(Item.class);
		Func1<Item, Integer> selector = null;
		Action0 action = () -> source.minInt(selector);
		Assert2.assertNullPointerExceptionThrown("selector", action);
	}

	@Test
	public void empty() {
		IEnumerable<Item> source = Enumerable.empty(Item.class);
		Func1<Item, Integer> selector = item -> item.value;
		Class<? extends Exception> exceptionClass = UnsupportedOperationException.class;
		Action0 action = () -> source.minInt(selector);
		Assert2.assertExceptionThrown(exceptionClass, action);
	}

	@Test
	public void normal() {
		IEnumerable<Item> source = () -> Enumerable.of(new Item(2), new Item(1), new Item(3)).iterator();
		Func1<Item, Integer> selector = item -> item.value;
		int expected = 1;
		int actual = source.minInt(selector);
		Assert.assertEquals(expected, actual);
	}

	private static class Item {
		public Item(int value) {
			this.value = value;
		}

		public final int value;
	}
}
