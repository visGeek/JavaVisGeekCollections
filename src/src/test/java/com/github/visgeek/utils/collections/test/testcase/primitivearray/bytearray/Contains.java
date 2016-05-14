package com.github.visgeek.utils.collections.test.testcase.primitivearray.bytearray;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IByteEnumerable;

public class Contains {
	@Test
	public void contains() {
		byte[] source = new byte[] { 1, 2, 3 };
		Byte target = 2;
		boolean expected = true;

		IByteEnumerable enumerable = Enumerable.of(source);
		boolean actual = enumerable.contains(target);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void notContains() {
		byte[] source = new byte[] { 1, 2, 3 };
		Byte target = 4;
		boolean expected = false;

		IByteEnumerable enumerable = Enumerable.of(source);
		boolean actual = enumerable.contains(target);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void argIsNull() {
		byte[] source = new byte[] { 1, 2, 3 };
		Byte target = null;
		boolean expected = false;

		IByteEnumerable enumerable = Enumerable.of(source);
		boolean actual = enumerable.contains(target);
		Assert.assertEquals(expected, actual);
	}
}
