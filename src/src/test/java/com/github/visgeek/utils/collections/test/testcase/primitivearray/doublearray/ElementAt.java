package com.github.visgeek.utils.collections.test.testcase.primitivearray.doublearray;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class ElementAt {
	@Test
	public void testSuccess() {
		IEnumerable<Double> source = Enumerable.of(1.0, 2.0, 3.0);
		int index = 1;
		double expected = 2.0;

		double actual = source.elementAt(index);
		Assert.assertEquals(expected, actual, 0);
	}

	@Test
	public void testIndexOutOfRange01() {
		IEnumerable<Double> source = Enumerable.of(1.0, 2.0, 3.0);
		Action0 action = () -> source.elementAt(-1);
		Assert2.assertExceptionThrown(IllegalArgumentException.class, action);
	}

	@Test
	public void testIndexOutOfRange022() {
		IEnumerable<Double> source = Enumerable.of(1.0, 2.0, 3.0);
		Action0 action = () -> source.elementAt(4);
		Assert2.assertExceptionThrown(IllegalArgumentException.class, action);
	}
}
