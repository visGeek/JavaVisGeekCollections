package com.github.visgeek.utils.collections.test.testcase.arrayenumerableint;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class ElementAt {
	@Test
	public void testSuccess() {
		IEnumerable<Integer> source = Enumerable.of(1, 2, 3);
		int index = 1;
		int expected = 2;

		int actual = source.elementAt(index);
		Assert.assertEquals(expected, actual, 0);
	}

	@Test
	public void testIndexOutOfRange01() {
		IEnumerable<Integer> source = Enumerable.of(1, 2, 3);
		Action0 action = () -> source.elementAt(-1);
		Assert2.assertExceptionThrown(IllegalArgumentException.class, action);
	}

	@Test
	public void testIndexOutOfRange022() {
		IEnumerable<Integer> source = Enumerable.of(1, 2, 3);
		Action0 action = () -> source.elementAt(4);
		Assert2.assertExceptionThrown(IllegalArgumentException.class, action);
	}
}
