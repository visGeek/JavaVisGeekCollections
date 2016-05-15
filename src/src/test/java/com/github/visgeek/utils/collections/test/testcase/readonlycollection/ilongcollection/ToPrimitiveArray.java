package com.github.visgeek.utils.collections.test.testcase.readonlycollection.ilongcollection;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.ILongEnumerable;

public class ToPrimitiveArray {
	@Test
	public void test() {
		Long[] source = new Long[] { null, 1L, 2L, 3L };
		long[] expected = new long[] { 0, 1L, 2L, 3L };

		ILongEnumerable enumerable = Enumerable.of(source);
		long[] actual = enumerable.toPrimitiveArray();
		Assert.assertArrayEquals(expected, actual);
	}
}
