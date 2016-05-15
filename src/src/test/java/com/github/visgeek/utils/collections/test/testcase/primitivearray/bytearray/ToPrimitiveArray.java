package com.github.visgeek.utils.collections.test.testcase.primitivearray.bytearray;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IByteEnumerable;

public class ToPrimitiveArray {
	@Test
	public void test() {
		byte[] source = new byte[] { 1, 2, 3 };
		byte[] expected = source;

		IByteEnumerable enumerable = Enumerable.of(source);
		byte[] actual = enumerable.toPrimitiveArray();
		Assert.assertArrayEquals(expected, actual);
	}
}
