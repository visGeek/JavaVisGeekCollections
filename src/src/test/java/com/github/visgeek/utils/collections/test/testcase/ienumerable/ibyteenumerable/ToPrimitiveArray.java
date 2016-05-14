package com.github.visgeek.utils.collections.test.testcase.ienumerable.ibyteenumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IByteEnumerable;

public class ToPrimitiveArray {
	@Test
	public void test() {
		IByteEnumerable source = Enumerable.of(null, 0, 1, 2).selectByte(n -> n == null ? null : n.byteValue());
		byte[] expected = new byte[] { 0, 0, 1, 2 };

		byte[] actual = source.toPrimitiveArray();
		Assert.assertArrayEquals(expected, actual);
	}
}
