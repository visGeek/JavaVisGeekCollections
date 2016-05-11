package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances.idoublecollectionenumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IDoubleEnumerable;

public class ToArray {
	@Test
	public void test() {
		IDoubleEnumerable source = Enumerable.of(new Double[] { null, 1.0, 2.0, 3.0 });
		double[] expected = new double[] { 0.0, 1.0, 2.0, 3.0 };

		double[] actual = source.toPrimitiveArray();
		Assert.assertArrayEquals(expected, actual, 0);
	}
}
