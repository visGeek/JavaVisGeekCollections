package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.Func1;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class MaxCharacter {
	@Test
	public void argIsNull() {
		IEnumerable<Item> source = Enumerable.empty(Item.class);
		Func1<Item, Character> selector = null;
		Action0 action = () -> source.maxCharacter(selector);
		Assert2.assertNullPointerExceptionThrown("selector", action);
	}

	@Test
	public void empty() {
		IEnumerable<Item> source = Enumerable.empty(Item.class);
		Func1<Item, Character> selector = item -> item.value;
		Class<? extends Exception> exceptionClass = UnsupportedOperationException.class;
		Action0 action = () -> source.maxCharacter(selector);
		Assert2.assertExceptionThrown(exceptionClass, action);
	}

	@Test
	public void normal() {
		IEnumerable<Item> source = () -> Enumerable.of(new Item('a'), new Item('b'), new Item('c')).iterator();
		Func1<Item, Character> selector = item -> item.value;
		Character expected = 'c';
		Character actual = source.maxCharacter(selector);
		Assert.assertEquals(expected, actual);
	}

	private static class Item {
		public Item(Character value) {
			this.value = value;
		}

		public final Character value;
	}
}
