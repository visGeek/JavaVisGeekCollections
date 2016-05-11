package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances.arrayenumerablelong;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class ElementAt {
	@Test
	public void testSuccess() {
		IEnumerable<Long> source = Enumerable.of(new long[] { 1L, 2L, 3L });
		int index = 1;
		long expected = 2L;

		long actual = source.elementAt(index);
		Assert.assertEquals(expected, actual, 0);
	}

	@Test
	public void testIndexOutOfRange01() {
		IEnumerable<Long> source = Enumerable.of(new long[] { 1L, 2L, 3L });
		Action0 action = () -> source.elementAt(-1);
		Assert2.assertExceptionThrown(IllegalArgumentException.class, action);
	}

	@Test
	public void testIndexOutOfRange022() {
		IEnumerable<Long> source = Enumerable.of(new long[] { 1L, 2L, 3L });
		Action0 action = () -> source.elementAt(4);
		Assert2.assertExceptionThrown(IllegalArgumentException.class, action);
	}
}
