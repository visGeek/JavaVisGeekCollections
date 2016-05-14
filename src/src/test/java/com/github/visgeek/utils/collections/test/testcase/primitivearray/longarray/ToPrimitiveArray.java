package com.github.visgeek.utils.collections.test.testcase.primitivearray.longarray;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.ILongEnumerable;

public class ToPrimitiveArray {
	@Test
	public void test() {
		ILongEnumerable source = Enumerable.of(1L, 2L, 3L);
		long[] expected = new long[] { 1L, 2L, 3L };

		long[] actual = source.toPrimitiveArray();
		Assert.assertArrayEquals(expected, actual);
	}
}