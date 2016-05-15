package com.github.visgeek.utils.collections.test.testcase.primitivearray.bytearray;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IByteEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class Iterator {
	@Test
	public void test() {
		byte[] source = new byte[] { 1, 2, 3 };
		Byte[] expected = new Byte[] { 1, 2, 3 };;

		IByteEnumerable enumerable = Enumerable.of(source);
		Assert2.assertSequanceEquals(enumerable, expected);
	}
}
