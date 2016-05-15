package com.github.visgeek.utils.collections.test.testcase.readonlycollection.idoublecollection;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IDoubleEnumerable;

public class ToPrimitiveArray {
	@Test
	public void test() {
		Double[] source = new Double[] { null, 1.0, 2.0, 3.0 };
		double[] expected = new double[] { 0.0, 1.0, 2.0, 3.0 };

		IDoubleEnumerable enumerable = Enumerable.of(source);
		double[] actual = enumerable.toPrimitiveArray();
		Assert.assertArrayEquals(expected, actual, 0);
	}
}
