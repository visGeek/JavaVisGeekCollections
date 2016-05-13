package com.github.visgeek.utils.collections.test.testcase.arrayenumerabledouble;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IDoubleEnumerable;

public class ToPrimitiveArray {
	@Test
	public void test() {
		IDoubleEnumerable source = Enumerable.of(1.0, 2.0, 3.0);
		double[] expected = new double[] { 1.0, 2.0, 3.0 };

		double[] actual = source.toPrimitiveArray();
		Assert.assertArrayEquals(expected, actual, 0);
	}
}
