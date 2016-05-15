package com.github.visgeek.utils.collections.test.testcase.primitivearray.bytearray;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IByteEnumerable;

public class Count {
	@Test
	public void testSuccess() {
		byte[] source = new byte[] { 1, 2, 3 };
		int expected = source.length;

		IByteEnumerable enumerable = Enumerable.of(source);
		int actual = enumerable.count();
		Assert.assertEquals(expected, actual);
	}
}
