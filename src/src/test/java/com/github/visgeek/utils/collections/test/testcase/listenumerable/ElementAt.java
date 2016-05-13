package com.github.visgeek.utils.collections.test.testcase.listenumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class ElementAt {
	@Test
	public void test01() {
		IEnumerable<Item> source = Enumerable.of(new Item(1), new Item(2), new Item(3));
		Item actual = source.elementAt(1);
		Assert.assertEquals(2, actual.value());
	}

	@Test
	public void testIndexOutOfRange01() {
		IEnumerable<Item> source = Enumerable.of(new Item(1), new Item(2), new Item(3));
		Action0 action = () -> source.elementAt(-1);
		Assert2.assertExceptionThrown(IllegalArgumentException.class, action);
	}

	@Test
	public void testIndexOutOfRange02() {
		IEnumerable<Item> source = Enumerable.of(new Item(1), new Item(2), new Item(3));
		Action0 action = () -> source.elementAt(4);
		Assert2.assertExceptionThrown(IllegalArgumentException.class, action);
	}
}
