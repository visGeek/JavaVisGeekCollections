package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances.listenumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;

public class Contains {
	@Test
	public void contains() {
		IEnumerable<Item> source = Enumerable.of(new Item(1), new Item(2), new Item(3));
		Item target = new Item(2);
		boolean expected = true;

		boolean actual = source.contains(target);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void notContains() {
		IEnumerable<Item> source = Enumerable.of(new Item(1), new Item(2), new Item(3));
		Item target = new Item(4);
		boolean expected = false;

		boolean actual = source.contains(target);
		Assert.assertEquals(expected, actual);
	}
}
