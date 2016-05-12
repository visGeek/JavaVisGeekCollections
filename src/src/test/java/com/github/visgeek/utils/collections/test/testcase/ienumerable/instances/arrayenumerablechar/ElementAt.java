package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances.arrayenumerablechar;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class ElementAt {
	@Test
	public void testSuccess() {
		IEnumerable<Character> source = Enumerable.of('a', 'b', 'c');
		int index = 1;
		char expected = 'b';

		char actual = source.elementAt(index);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testIndexOutOfRange01() {
		IEnumerable<Character> source = Enumerable.of('a', 'b', 'c');
		Action0 action = () -> source.elementAt(-1);
		Assert2.assertExceptionThrown(IllegalArgumentException.class, action);
	}

	@Test
	public void testIndexOutOfRange022() {
		IEnumerable<Character> source = Enumerable.of('a', 'b', 'c');
		Action0 action = () -> source.elementAt(4);
		Assert2.assertExceptionThrown(IllegalArgumentException.class, action);
	}
}
