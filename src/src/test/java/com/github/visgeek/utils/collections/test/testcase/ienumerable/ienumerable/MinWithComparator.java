package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import java.util.Comparator;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;
import com.github.visgeek.utils.testing.CollectionCreator;

public class MinWithComparator {
	@Rule
	public final ExpectedException expectedException = ExpectedException.none();

	@Test
	public void argIsNull() {
		Assert2.assertNullPointerExceptionThrown(this.expectedException, "comparator");

		Item[] source = new Item[] {};
		Comparator<Item> comparator = null;

		IEnumerable<Item> enumerable = () -> CollectionCreator.iterator(source);
		enumerable.min(comparator);
	}

	@Test
	public void empty() {
		Item[] source = new Item[] {};
		Comparator<Item> comparator = Comparator.comparing(item -> item.value);
		Item expected = null;

		IEnumerable<Item> enumerable = () -> CollectionCreator.iterator(source);
		Item actual = enumerable.min(comparator);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void normal() {
		Item[] source = new Item[] { new Item(2), new Item(1), null, new Item(3) };
		Comparator<Item> comparator = Comparator.comparing(item -> item.value);
		int expected = 1;

		IEnumerable<Item> enumerable = () -> CollectionCreator.iterator(source);
		Item actual = enumerable.min(comparator);
		Assert.assertEquals(expected, actual.value);
	}

	private static class Item {
		public Item(int value) {
			this.value = value;
		}

		public final int value;
	}
}
