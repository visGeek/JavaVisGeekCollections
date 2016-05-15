package com.github.visgeek.utils.collections.test.testcase.readonlycollection.ibytecollection;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IByteEnumerable;

public class ToPrimitiveArray {
	@Test
	public void test() {
		Byte[] source = new Byte[] { null, 1, 2, 3 };
		byte[] expected = new byte[] { 0, 1, 2, 3 };

		IByteEnumerable enumerable = Enumerable.of(source);
		byte[] actual = enumerable.toPrimitiveArray();
		Assert.assertArrayEquals(expected, actual);
	}
}
