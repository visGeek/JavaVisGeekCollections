package com.github.visgeek.utils.collections.test.testcase.idoubleenumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IDoubleEnumerable;

public class ToPrimitiveArray {
	@Test
	public void test() {
		IDoubleEnumerable source = Enumerable.of(null, 1.0, 2.0, 3.0).selectDouble(n -> n);
		double[] expected = new double[] { 0.0, 1.0, 2.0, 3.0 };

		double[] actual = source.toPrimitiveArray();
		Assert.assertArrayEquals(expected, actual, 0);
	}
}
