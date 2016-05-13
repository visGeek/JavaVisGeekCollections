package com.github.visgeek.utils.collections.test.testcase.ienumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.Func1;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class MaxLong {
	@Test
	public void argIsNull() {
		IEnumerable<Item> source = Enumerable.empty(Item.class);
		Func1<Item, Long> selector = null;
		Action0 action = () -> source.maxLong(selector);
		Assert2.assertNullPointerExceptionThrown("selector", action);
	}

	@Test
	public void empty() {
		IEnumerable<Item> source = Enumerable.empty(Item.class);
		Func1<Item, Long> selector = item -> item.value;
		Class<? extends Exception> exceptionClass = UnsupportedOperationException.class;
		Action0 action = () -> source.maxLong(selector);
		Assert2.assertExceptionThrown(exceptionClass, action);
	}

	@Test
	public void normal() {
		IEnumerable<Item> source = () -> Enumerable.of(new Item(2L), new Item(1L), new Item(3L)).iterator();
		Func1<Item, Long> selector = item -> item.value;
		Long expected = 3L;
		Long actual = source.maxLong(selector);
		Assert.assertEquals(expected, actual);
	}

	private static class Item {
		public Item(Long value) {
			this.value = value;
		}

		public final Long value;
	}
}
