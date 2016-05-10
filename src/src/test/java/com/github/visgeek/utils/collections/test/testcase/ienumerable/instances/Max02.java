package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import java.util.Comparator;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class Max02 {
	@Test
	public void argIsNull() {
		IEnumerable<Item> source = Enumerable.empty(Item.class);
		Comparator<Item> comparator = null;
		Action0 action = () -> source.max(comparator);
		Assert2.assertNullPointerExceptionThrown("comparator", action);
	}

	@Test
	public void empty() {
		IEnumerable<Item> source = Enumerable.empty(Item.class);
		Comparator<Item> comparator = Comparator.comparing(item -> item.value);
		Class<? extends Exception> exceptionClass = UnsupportedOperationException.class;
		Action0 action = () -> source.max(comparator);
		Assert2.assertExceptionThrown(exceptionClass, action);
	}

	@Test
	public void normal() {
		IEnumerable<Item> source = () -> Enumerable.of(new Item(2), new Item(1), new Item(3)).iterator();
		Comparator<Item> comparator = Comparator.comparing(item -> item.value);
		int expected = 3;
		Item actual = source.max(comparator);
		Assert.assertEquals(expected, actual.value);
	}

	private static class Item {
		public Item(int value) {
			this.value = value;
		}

		public final int value;
	}
}
